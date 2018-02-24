package com.mine.hash;

public class HashFuction {
	private final int SEEd_MAX_LENTH = 10;

	public long BKDRHash(String s) {
		final long seed = productSeed();
		return BKDRHash(s, seed);
	}

	public long BKDRHash(String s, long seed) {
		long hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash = (hash * seed) + s.charAt(i);
		}
		return hash;
	}

	public long productSeed() {
		long seed = 0;
		int temp;
		int turn = (int) (Math.random() * SEEd_MAX_LENTH) + 3;
		for (int i = 0; i < turn; i++) {
			if (Math.random() < 0.5)
				temp = 1;
			else
				temp = 3;
			seed += numberExponential(10, i) * temp;
		}
		return seed;
	}

	private long numberExponential(int n, int e) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		long temp = 1;
		for (int i = 0; i < e; i++) {
			temp *= n;
		}
		return temp;
	}
}
