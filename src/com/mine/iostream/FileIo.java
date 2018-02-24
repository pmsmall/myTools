package com.mine.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * this class include the way using io stream of file put in and out
 * 
 * @author Frank
 * 
 * @param readFile
 *            read the specific file
 * @param writeFile
 *            write the data in specific file
 */
public class FileIo {
	private File file;
	private InputStream input;
	private OutputStream output;
	private BufferedOutputStream bufferOut;
	private BufferedInputStream bufferIn;
	private BufferedReader bufreader;
	public final String OPEN = "open", WRITE = "write",
			BUFFERED_OPEN = "bopen", BUFFERED_WRITE = "bwrite",
			BUFFERED_READ = "bread";
	private String fileway;

	private String way;

	public FileIo(String fileWay, String way) {
		this.way = way;
		this.fileway = fileWay;
		file = new File(fileWay);
		try {
			if (way.equals(OPEN)) {
				input = new FileInputStream(file);
			} else if (way.equals(WRITE)) {
				output = new FileOutputStream(file);
			} else if (way.equals(BUFFERED_OPEN)) {
				bufferIn = new BufferedInputStream(input = new FileInputStream(
						file));
			} else if (way.equals(BUFFERED_WRITE)) {
				bufferOut = new BufferedOutputStream(
						output = new FileOutputStream(file));
			} else if (way.equals(BUFFERED_READ)) {
				bufreader = new BufferedReader(new InputStreamReader(
						input = new FileInputStream(file)));
			} else {
				throw new IllegalAccessError("非法字符!");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param fileWay
	 *            文件路径
	 * @return 文本文件内容
	 */
	public static String readFile(String fileWay) {
		File file = new File(fileWay);
		try {
			InputStream input = new FileInputStream(file);
			int length = input.available();
			byte[] b = new byte[length];
			input.read(b);
			input.close();
			return new String(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot find the file!");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot find the file!");
			return null;
		}
	}

	/**
	 * 
	 * @param fileName
	 *            文件路径
	 * @param b
	 *            要存的内容
	 * @return 存储情况，是否成功
	 */
	public static boolean writeFile(String fileName, byte[] b) {
		File file = new File(fileName);
		try {
			OutputStream output = new FileOutputStream(file);
			output.write(b);
			output.flush();
			output.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot find the file!");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot find the file!");
			return false;
		}
	}

	/**
	 * 
	 * @param fileName
	 *            文件路径
	 * @param s
	 *            要存的内容
	 * @return 存储情况，是否成功
	 */
	public static boolean writeFile(String fileName, String s) {
		byte[] b = s.getBytes();
		return writeFile(fileName, b);
	}

	/**
	 * 读取一个字节
	 * 
	 * @return 读取的字节
	 */
	public byte read() {
		byte b;
		try {
			b = (byte) input.read();
			return b;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Byte) null;
		}
	}

	public String readLine() {
		if (way.equals(BUFFERED_READ)) {
			String s;
			try {
				s = bufreader.readLine();
				return s;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return (String) null;
			}
		} else {
			final FileIo fio = new FileIo(fileway, BUFFERED_READ);
			return fio.readLine();
		}
	}

	/**
	 * 写入文本
	 * 
	 * @param s
	 *            需要写入的文本
	 * @return 是否写入成功，成功返回true，失败返回false
	 */
	public boolean write(String s) {
		return write(s.getBytes());
	}

	/**
	 * 写入一个字节
	 * 
	 * @param s
	 *            需要写入的字节
	 * @return 是否写入成功，成功返回true，失败返回false
	 */
	public boolean write(byte b) {
		try {
			output.write(b);
			output.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 写入字节数组
	 * 
	 * @param s
	 *            需要写入的字节数组
	 * @return 是否写入成功，成功返回true，失败返回false
	 */
	public boolean write(byte[] b) {
		try {
			output.write(b);
			output.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 写入字符数组
	 * 
	 * @param s
	 *            需要写入的字符数组
	 * @return 是否写入成功，成功返回true，失败返回false
	 */
	public boolean write(char[] c) {
		return write(new String(c));
	}

	/**
	 * 写入字符
	 * 
	 * @param s
	 *            需要写入的字符
	 * @return 是否写入成功，成功返回true，失败返回false
	 */
	public boolean write(char c) {
		return write((byte) c);
	}

	/**
	 * 关闭文件
	 * 
	 * @return 成功关闭返回true，失败返回false
	 */
	public boolean close() {
		try {
			if (way.equals(OPEN)) {
				input.close();
			} else if (way.equals(WRITE)) {
				output.flush();
				output.close();
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
