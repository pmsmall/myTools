package com.mine.matrix;

public class Calculate {

	// 重要权重
	private double[] importantW;
	private double weightOfImportantWeight;

	// 次要权重
	private double[] unimportantW;
	private double weightOfUnimportantWeight;
	private Matrix imatrix, umatrix, matrix, finalMatrix;

	private Coordinate[] c;

	public Calculate(Matrix matrix, double[] importantW) {
		init(matrix, importantW, null);
	}

	public Calculate(Matrix matrix, double[] importantW, double[] unimportantW) {
		init(matrix, importantW, unimportantW);
	}

	public Calculate(Matrix matrix, double[] importantW, double[] unimportantW, int weightOfImportantWeight,
			int weightOfUnimportantWeight) {
		init(matrix, importantW, unimportantW, weightOfImportantWeight, weightOfUnimportantWeight);
	}

	public void init(Matrix matrix, double[] importantW, double[] unimportantW, int weightOfImportantWeight,
			int weightOfUnimportantWeight) {
		init(matrix, importantW, unimportantW);
		this.weightOfImportantWeight = weightOfImportantWeight;
		this.weightOfUnimportantWeight = weightOfUnimportantWeight;
	}

	public void init(Matrix matrix, double[] importantW, double[] unimportantW) {
		this.matrix = matrix;
		setImatrix(importantW);
		setUmatrix(unimportantW);
	}

	public void setImportanWeight(double[] importantW) {
		this.importantW = importantW;
	}

	public void setUnimportanWeight(double[] unimportantW) {
		this.unimportantW = unimportantW;
	}

	private void setImatrix(double[] importantW) {
		setImportanWeight(importantW);
		setImatrix();
	}

	private void setUmatrix(double[] unimportantW) {
		setUnimportanWeight(unimportantW);
		setUmatrix();
	}

	private void setImatrix() {
		imatrix = new Matrix(importantW);
		imatrix.transfer();
	}

	private void setUmatrix() {
		umatrix = new Matrix(unimportantW);
		umatrix.transfer();
	}

	public void calculate() {
		if (imatrix != null) {
			Matrix temp = new Matrix(matrix);
			temp.multiply(imatrix);
			double max = temp.getMaxEInSpecificCol(temp.getCols());
			c = temp.findElement(max);
			temp = temp.getSubMatrix(c);
			if (umatrix != null) {
				Matrix temp2 = new Matrix(temp);
				temp2.multiply(umatrix);
				max = temp2.getMaxEInSpecificCol(temp2.getCols());
				c = temp2.findElement(max);
				temp = temp2.getSubMatrix(c);
			}
			finalMatrix = temp;
		}
	}

	public Matrix getResult() {
		if (finalMatrix == null)
			calculate();
		return finalMatrix;
	}
}
