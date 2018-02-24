package com.mine.encrypt;

public class Main {
	public static void main(String[] args) {

		// RSAFrame f = new RSAFrame();
		// f.build();

		String s = "222";
		byte[] b;
		RSAManager m = new RSAManager();
		b = m.encrypt(s);
		s = new String(m.decrypt(b));
		System.out.println(s);

		// long a = System.currentTimeMillis();
		// Java
		// System.out.println(java.math.BigInteger.ONE.shiftLeft(1024));
		// System.out.println(BigIntegerMath.sqrt("123456789"));
		// System.out.println(Math.sqrt(123456789));
		// System.out.println(Math.random());
		// double d = Math.random();
		// System.out.println(d);
		// System.out.println(new Integer(1111).toString());

		// encrypt e = new encrypt();
		// int i = 1;
		// BigInteger b = new BigInteger(
		// ""), temp1, temp2;
		// while (true) {
		// temp1 = java.math.BigInteger.ONE.shiftLeft(i);
		// temp2 = java.math.BigInteger.ONE.shiftLeft(i + 1);
		// if (temp1.compareTo(b) * temp2.compareTo(b) < 0) {
		// System.out.println(temp2.getLowestSetBit());
		// break;
		// }
		// i++;
		// }
		// e.findPrime();

		// e.produce();

		// System.out.println(e.makeRandom());
		// System.out.println((long)(d * 10000000000000000.0));
		// System.out.println("\r<br>Ö´ÐÐºÄÊ± : " + (System.currentTimeMillis() - a)
		// / 1000f + " Ãë ");
	}
}
