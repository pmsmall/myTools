package com.mine.matrix;

public class ByteHash {

	public final int length;
	private byte[] data;
	private final long hash;

	public ByteHash(float[] f) {
		length = 8 * f.length;
		data = new byte[length];
		byte[] temp;
		for (int i = 0; i < f.length; i++) {
			temp = floatToByte(f[i]);
			for (int j = 0; j < 8; j++) {
				data[i * 8 + j] = temp[j];
			}
		}
		hash = initHash();
	}

	/**
	 * 将浮点转换成byte数组
	 * 
	 * @param d
	 * @return
	 */
	public byte[] floatToByte(float d) {
		byte[] b = new byte[8];
		long l = Double.doubleToLongBits(d);
		for (int i = 0; i < b.length; i++) {
			b[i] = new Long(l).byteValue();
			l = l >> 8;
		}
		return b;
	}

	private long initHash() {
		long l = 0;
		for (int i = 0; i < length; i++) {
			l <<= 8;
			l |= (data[i] & 0xff);
		}
		return l;
	}

	public long getHash() {
		return hash;
	}
}
