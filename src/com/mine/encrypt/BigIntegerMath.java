package com.mine.encrypt;

import java.math.BigInteger;

public class BigIntegerMath {

	public static BigInteger sqrt(BigInteger bi) {
		BigIntegerMath bimath = new BigIntegerMath();
		return bimath.getValueOfSqrt(bi);
	}

	private BigInteger getValueOfSqrt(BigInteger bi) {
		if (bi.compareTo(BigInteger.ZERO) < 0) {
			System.out.println("不是正数，不能开方");
			return null;
		} else {
			BigInteger try1 = null, try2 = null, twenty = new BigInteger("20"), divided;
			String sqr = "0", pre = "0";
			int length = bi.toString().length();
			if (length % 2 == 0) {
				for (int i = 0; i < length / 2; i++) {
					divided = new BigInteger(pre
							+ bi.toString().substring(2 * i, 2 * i + 2));
					for (int j = 0; j <= 9; j++) {
						try1 = twenty
								.multiply(new BigInteger(sqr))
								.multiply(new BigInteger(j + ""))
								.add(new BigInteger(j + "")
										.multiply(new BigInteger(j + "")));
						try2 = twenty
								.multiply(new BigInteger(sqr))
								.multiply(new BigInteger((j + 1) + ""))
								.add(new BigInteger((j + 1) + "")
										.multiply(new BigInteger((j + 1) + "")));
						if (try1.subtract(divided).compareTo(BigInteger.ZERO) <= 0
								&& try2.subtract(divided).compareTo(
										BigInteger.ZERO) > 0) {
							sqr += j;
							pre = divided.subtract(try1).toString();
							break;
						}

					}
				}
			} else {
				for (int i = 0; i < length / 2 + 1; i++) {
					if (i == 0)
						divided = new BigInteger(bi.toString().charAt(0) + "");
					else
						divided = new BigInteger(pre
								+ bi.toString().substring(2 * i - 1, 2 * i + 1));
					for (int j = 0; j <= 9; j++) {
						try1 = twenty
								.multiply(new BigInteger(sqr))
								.multiply(new BigInteger(j + ""))
								.add(new BigInteger(j + "")
										.multiply(new BigInteger(j + "")));
						try2 = twenty
								.multiply(new BigInteger(sqr))
								.multiply(new BigInteger((j + 1) + ""))
								.add(new BigInteger((j + 1) + "")
										.multiply(new BigInteger((j + 1) + "")));
						if (try1.subtract(divided).compareTo(BigInteger.ZERO) <= 0
								&& try2.subtract(divided).compareTo(
										BigInteger.ZERO) > 0) {
							sqr += j;
							pre = divided.subtract(try1).toString();
							break;
						}
					}
				}
			}
			return new BigInteger(sqr);
		}
	}

	public static String sqrt(String s) {
		BigInteger b = BigIntegerMath.sqrt(new BigInteger(s));
		if (b != null)
			return b.toString();
		else
			return null;
	}
}
