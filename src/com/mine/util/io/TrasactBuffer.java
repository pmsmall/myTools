package com.mine.util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TrasactBuffer {

	byte[] buff;
	int head;
	int end;
	boolean lastRead;
	Object inputLock;
	Object outputLock;

	public TrasactBuffer(int capacity) {
		buff = new byte[capacity];
		head = 0;
		end = 0;
		lastRead = true;
		inputLock = new Object();
		outputLock = new Object();
	}

	private InputStream blockInput = new buffInputStream() {

		@Override
		public int read() throws IOException {
			byte result = -1;
			synchronized (buff) {
				synchronized (inputLock) {
					if ((end == head) && lastRead) {
						try {
							inputLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				result = buff[end % buff.length];
				lastRead = true;
				synchronized (outputLock) {
					// if (head == end && !lastRead) {
					outputLock.notify();
					// }
				}
				end++;
			}
			return result;
		}
	};

	private InputStream input = new buffInputStream() {

		@Override
		public int read() throws IOException {
			// System.out.println(new String(buff, head % buff.length, (end -
			// head + buff.length) % buff.length));
			boolean success = true;
			byte result = -1;
			synchronized (buff) {
				synchronized (inputLock) {
					if ((end == head) && lastRead) {
						success = false;
					}
				}

				if (success)
					result = buff[end % buff.length];
				lastRead = true;
				synchronized (outputLock) {
					outputLock.notify();
				}
				if (success)
					end++;
			}
			return result;
		}

	};

	private OutputStream out = new OutputStream() {

		@Override
		public void write(int b) throws IOException {
			new Exception().printStackTrace();
			synchronized (buff) {
				synchronized (outputLock) {
					if (head == end && !lastRead) {
						try {
							outputLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				buff[head % buff.length] = (byte) b;
				lastRead = false;
				synchronized (inputLock) {
					// if (head == end && lastRead) {
					inputLock.notify();
					// }
				}
				head++;
			}
		}

		/**
		 * Writes <code>b.length</code> bytes from the specified byte array to
		 * this output stream. The general contract for <code>write(b)</code> is
		 * that it should have exactly the same effect as the call
		 * <code>write(b, 0, b.length)</code>.
		 *
		 * @param b
		 *            the data.
		 * @exception IOException
		 *                if an I/O error occurs.
		 * @see java.io.OutputStream#write(byte[], int, int)
		 */
		public void write(byte b[]) throws IOException {
			write(b, 0, b.length);
		}

		/**
		 * Writes <code>len</code> bytes from the specified byte array starting
		 * at offset <code>off</code> to this output stream. The general
		 * contract for <code>write(b, off, len)</code> is that some of the
		 * bytes in the array <code>b</code> are written to the output stream in
		 * order; element <code>b[off]</code> is the first byte written and
		 * <code>b[off+len-1]</code> is the last byte written by this operation.
		 * <p>
		 * The <code>write</code> method of <code>OutputStream</code> calls the
		 * write method of one argument on each of the bytes to be written out.
		 * Subclasses are encouraged to override this method and provide a more
		 * efficient implementation.
		 * <p>
		 * If <code>b</code> is <code>null</code>, a
		 * <code>NullPointerException</code> is thrown.
		 * <p>
		 * If <code>off</code> is negative, or <code>len</code> is negative, or
		 * <code>off+len</code> is greater than the length of the array
		 * <code>b</code>, then an <tt>IndexOutOfBoundsException</tt> is thrown.
		 *
		 * @param b
		 *            the data.
		 * @param off
		 *            the start offset in the data.
		 * @param len
		 *            the number of bytes to write.
		 * @exception IOException
		 *                if an I/O error occurs. In particular, an
		 *                <code>IOException</code> is thrown if the output
		 *                stream is closed.
		 */
		public void write(byte b[], int off, int len) throws IOException {
			// new Exception().printStackTrace(System.out);
			if (b == null) {
				throw new NullPointerException();
			} else if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) > b.length) || ((off + len) < 0)) {
				throw new IndexOutOfBoundsException();
			} else if (len == 0) {
				return;
			}
			synchronized (buff) {
				synchronized (outputLock) {
					while ((!lastRead && head == end)
							|| (head != end) && ((head - end + buff.length) % buff.length < len)) {
						try {
							outputLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				if (head % buff.length + len < buff.length) {
					System.arraycopy(b, off, buff, head % buff.length, len);
				} else {
					int len1 = head % buff.length + len - buff.length;
					System.arraycopy(b, off, buff, head % buff.length, len - len1);
					System.arraycopy(b, off + len - len1, buff, 0, len);
				}
				lastRead = false;
				head += len;
				synchronized (inputLock) {
					// if (head == end && lastRead) {
					inputLock.notify();
					// }
				}
			}
		}

		/**
		 * Flushes this output stream and forces any buffered output bytes to be
		 * written out. The general contract of <code>flush</code> is that
		 * calling it is an indication that, if any bytes previously written
		 * have been buffered by the implementation of the output stream, such
		 * bytes should immediately be written to their intended destination.
		 * <p>
		 * If the intended destination of this stream is an abstraction provided
		 * by the underlying operating system, for example a file, then flushing
		 * the stream guarantees only that bytes previously written to the
		 * stream are passed to the operating system for writing; it does not
		 * guarantee that they are actually written to a physical device such as
		 * a disk drive.
		 * <p>
		 * The <code>flush</code> method of <code>OutputStream</code> does
		 * nothing.
		 *
		 * @exception IOException
		 *                if an I/O error occurs.
		 */
		public void flush() throws IOException {
		}

		/**
		 * Closes this output stream and releases any system resources
		 * associated with this stream. The general contract of
		 * <code>close</code> is that it closes the output stream. A closed
		 * stream cannot perform output operations and cannot be reopened.
		 * <p>
		 * The <code>close</code> method of <code>OutputStream</code> does
		 * nothing.
		 *
		 * @exception IOException
		 *                if an I/O error occurs.
		 */
		public void close() throws IOException {
		}
	};

	public InputStream getInputStream() {
		return input;
	}

	public InputStream getBlockedInputStream() {
		return blockInput;
	}

	public OutputStream getOutputStream() {
		return out;
	}

	private abstract class buffInputStream extends InputStream {
		protected boolean cloaseFlag = false;

		/**
		 * Returns an estimate of the number of bytes that can be read (or
		 * skipped over) from this input stream without blocking by the next
		 * invocation of a method for this input stream. The next invocation
		 * might be the same thread or another thread. A single read or skip of
		 * this many bytes will not block, but may read or skip fewer bytes.
		 *
		 * <p>
		 * Note that while some implementations of {@code InputStream} will
		 * return the total number of bytes in the stream, many will not. It is
		 * never correct to use the return value of this method to allocate a
		 * buffer intended to hold all data in this stream.
		 *
		 * <p>
		 * A subclass' implementation of this method may choose to throw an
		 * {@link IOException} if this input stream has been closed by invoking
		 * the {@link #close()} method.
		 *
		 * <p>
		 * The {@code available} method for class {@code InputStream} always
		 * returns {@code 0}.
		 *
		 * <p>
		 * This method should be overridden by subclasses.
		 *
		 * @return an estimate of the number of bytes that can be read (or
		 *         skipped over) from this input stream without blocking or
		 *         {@code 0} when it reaches the end of the input stream.
		 * @exception IOException
		 *                if an I/O error occurs.
		 */
		public int available() throws IOException {
			if (head != end)
				return (end + buff.length - head) % buff.length;
			return lastRead ? 0 : buff.length;
		}

		/**
		 * Closes this input stream and releases any system resources associated
		 * with the stream.
		 *
		 * <p>
		 * The <code>close</code> method of <code>InputStream</code> does
		 * nothing.
		 *
		 * @exception IOException
		 *                if an I/O error occurs.
		 */
		public void close() throws IOException {
			cloaseFlag = true;
		}
	}

	public static void main(String[] args) throws IOException {
		TrasactBuffer buff = new TrasactBuffer(100);
		OutputStreamWriter writer = new OutputStreamWriter(buff.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(buff.getInputStream()));
		System.out.println(reader.readLine());
		writer.write("125\n125\n");
		writer.write("125\n125\n");
		writer.write("125\n125\n");
		writer.write("125\n125\n");
		writer.write("125\n125\n");
		writer.write("125\n125\n");
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
	}
}
