package com.mine.hash;

public class Manage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashFuction h = new HashFuction();
		for (int i = 2; i < 10; i++)
			System.out.println(h.BKDRHash(i + i + i + i + i + "", 131));
	}

}
