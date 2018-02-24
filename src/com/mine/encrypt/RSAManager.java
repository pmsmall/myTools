package com.mine.encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class RSAManager {

	private BigInteger p, q, n, e1, e2;

	public RSAManager() {
		setP();
		setQ();
		setE();
	}

	public byte[] encrypt(String s) {
		return RSAHelper.encrypt(s.getBytes(), e1, n);
	}

	public byte[] encrypt(byte[] b) {
		return RSAHelper.encrypt(b, e1, n);
	}

	public byte[] decrypt(String s) {
		return RSAHelper.decrypt(s.getBytes(), e2, n);
	}

	public byte[] decrypt(byte[] b) {
		return RSAHelper.decrypt(b, e2, n);
	}

	public void setP() {
		encrypt encrypt = new encrypt();
		p = encrypt.findPrime();
	}

	public void setQ() {
		encrypt encrypt = new encrypt();
		q = encrypt.findPrime();
	}

	public void setE() {
		n = p.multiply(q);
		final BigInteger t = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
		new Thread(new Runnable() {
			@Override
			public void run() {
				encrypt encrypt = new encrypt();
				// TODO Auto-generated method stub
				while (true) {
					e1 = encrypt.makeRandom();
					if (isPrime(e1, t)) {
						break;
					}
				}
				e2 = niyuan(e1, t);
			}
		}).run();

	}

	public boolean isPrime(BigInteger m, BigInteger n) {
		if ((m.compareTo(n)) < 0) {
			BigInteger tmp = m;
			m = n;
			n = tmp;
		}
		BigInteger c;
		while (!(c = m.mod(n)).equals(BigInteger.ZERO)) {
			m = n;
			n = c;
		}
		return n.equals(BigInteger.ONE);
	}

	public BigInteger findE2(BigInteger m, BigInteger n) {
		BigInteger e2;
		for (BigInteger i = new BigInteger("2");; i.add(BigInteger.ONE)) {
			if ((((n.multiply(i)).add(BigInteger.ONE)).mod(m)).equals(BigInteger.ZERO)) {
				e2 = (((n.multiply(i)).add(BigInteger.ONE)).divide(m));
				break;
			}
		}
		return e2;
	}

	public BigInteger niyuan(BigInteger a, BigInteger b) // 求550关于模1769的乘法逆元
	// 550*X(mod1769)=1
	// niyuan(1769,550)
	{
		BigInteger[] m = { BigInteger.ONE, BigInteger.ZERO, a };
		BigInteger[] n = { BigInteger.ZERO, BigInteger.ONE, b };
		BigInteger[] temp = new BigInteger[3];
		BigInteger q = BigInteger.ZERO; // 初始化
		boolean flag = true;
		while (flag) {
			q = m[2].divide(n[2]);
			for (int i = 0; i < 3; i++) {
				temp[i] = m[i].subtract(q.multiply(n[i]));
				m[i] = n[i];
				n[i] = temp[i];
			}
			if (n[2].equals(BigInteger.ONE)) {
				if (n[1].compareTo(BigInteger.ZERO) < 0) {
					n[1] = n[1].add(a);
				}
				return n[1];
			}
			if (n[2].equals(BigInteger.ZERO)) {
				flag = false;
			}
		}
		return BigInteger.ZERO;
	}
}
