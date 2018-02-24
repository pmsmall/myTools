package com.mine.encrypt;

import java.math.BigInteger;

public class encrypt {
	private BigInteger p, q;

	public boolean ifPrime(BigInteger temp) {
		boolean information = true;
		double a = System.currentTimeMillis();
		System.out.println(temp);
		for (BigInteger n = BigInteger.valueOf(3); n.compareTo(BigIntegerMath
				.sqrt(temp)) < 0; n = n.add(new BigInteger(2 + ""))) {
			if ((n.subtract(BigInteger.valueOf(3))).mod(
					BigInteger.TEN.multiply(BigInteger.valueOf(100)))
					.compareTo(BigInteger.ZERO) == 0) {
				System.out.println(n.toString() + "\tÖ´ÐÐºÄÊ±\t"
						+ (double) (System.currentTimeMillis() - a) + "ºÁÃë");
				a = System.currentTimeMillis();
			}
			if (temp.mod(n).compareTo(BigInteger.ZERO) == 0) {
				information = false;
				break;
			}

		}
		if (information)
			return true;
		else
			return false;
	}

	public BigInteger makeRandom() {
		int l = BigIntegerMath.sqrt(BigInteger.ONE.shiftLeft(1024))
				.getLowestSetBit();
		int n = (int) (Math.random() * l * 1.8);
		return java.math.BigInteger.ONE
				.shiftLeft(n)
				.multiply(
						BigInteger.valueOf((long) (Math.random() * 10000000000000000.0)))
				.divide(BigInteger.valueOf((long) 10000000000000000.0));
	}

	public BigInteger findPrime() {
		BigInteger temp;
		while (true) {
			temp = makeRandom();
			if (temp.isProbablePrime(1000)) {
				if (temp.isProbablePrime(1000000000)) {
					// if (ifPrime(temp)) {
					// System.out.println(temp);
					break;
					// }
				}
			}
		}
		return temp;
	}

	private void makePQ() {
		while (true) {
			p = findPrime();
			q = findPrime();
			if (p.multiply(q).compareTo(BigInteger.ONE.shiftLeft(1000)) >= 0)
				break;
		}
		System.out.println(p + ",\n" + q);
	}

	public void produce() {
		makePQ();
	}
}
