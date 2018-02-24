package com.mine.encrypt;

import java.math.BigInteger;

public class RSAHelper {
	public static byte[] encrypt(byte[] p, BigInteger e, BigInteger n) {
		BigInteger c = new BigInteger(p);
//		System.out.println(c+","+e+","+n);
		c = c.modPow(e, n);
		return c.toByteArray();
	}

	public static byte[] decrypt(byte[] c, BigInteger e, BigInteger n) {
		BigInteger p = new BigInteger(c);
		p = p.modPow(e, n);
		return p.toByteArray();
	}
}
