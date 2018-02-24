package com.mine.matrix;

public class Test {

	public void n() {
		double[][] a = { { 1, 2, 0 }, { 0, 2, 0 }, { 0, 0, 3 } };
		Matrix m = new Matrix(a);
		Matrix m1[] = { m, m, m };
		Matrix x = new Matrix(m1);
		// System.out.println(x);
		// m.multiply(m);
		x = new Matrix(m);
		m.transfer();
		System.out.println(m);
		System.out.println(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.n();
	}

}
