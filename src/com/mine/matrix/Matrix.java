package com.mine.matrix;

import java.util.ArrayList;

/**
 * 
 * @author Kang Tiannan
 *
 */
public class Matrix {
	private double[][] matrix;
	private int rows, cols;
	private double maxE, minE;

	public Matrix(double[][] matrix) {
		this.matrix = matrix;
		rows = matrix.length;
		cols = matrix[0].length;
	}

	public Matrix(double[] matrix) {
		this.matrix = new double[1][matrix.length];
		this.matrix[0] = matrix;
		rows = 1;
		cols = matrix.length;
	}

	public Matrix() {
		matrix = new double[0][0];
	}

	public Matrix(Matrix[] m) {
		int r = m[0].rows, c = m[0].cols;
		boolean ifLegal = true;
		for (int i = 1; i < m.length; i++) {
			if (m[i].rows != r || m[i].cols != c) {
				ifLegal = false;
			}
		}
		if (ifLegal) {
			rows = m[0].rows * m.length;
			cols = m[0].cols;
			matrix = new double[rows][cols];
			for (int i = 0; i < m[0].rows; i++)
				for (int j = 0; j < cols; j++)
					for (int k = 0; k < m.length; k++) {
						matrix[i + m[0].rows * k][j] = m[k].getElement(i + 1, j + 1);
					}
		} else {
			System.out.println("the Matrix array is illegal!");
		}
	}

	public Matrix(Matrix m) {
		rows = m.rows;
		cols = m.cols;
		matrix = new double[rows][cols];
		for (int i = 0; i < m.rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = m.getElement(i + 1, j + 1);
	}

	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		matrix = new double[rows][cols];
	}

	public boolean add(Matrix m) {
		if (m.getCols() != cols || m.getRows() != rows) {
			return false;
		} else {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] += m.getElementByIndex(i, j);
				}
			}
			return true;
		}
	}

	public boolean multiply(Matrix m) {
		if (cols == m.getRows()) {
			double[][] temp = new double[rows][m.getCols()];
			int t = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < m.getCols(); j++) {
					for (int k = 0; k < m.getRows(); k++) {
						t += matrix[i][k] * m.getElementByIndex(k, j);
					}
					temp[i][j] = t;
					t = 0;
				}
			}
			matrix = temp;
			return true;
		} else
			return false;
	}

	public String toString() {
		String s = new String();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				s += "(" + (i + 1) + "," + (j + 1) + ")=" + (matrix[i][j]) + " ";
			}
			s += "\n";
		}
		return s;
	}

	public void transfer() {
		double temp[][] = new double[cols][rows];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				temp[j][i] = matrix[i][j];
		matrix = temp;
	}

	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	public double getElement(int rows, int cols) {
		if (rows > 0 && rows <= this.rows && cols > 0 && cols <= this.rows)
			return matrix[rows - 1][cols - 1];
		else
			return 0;
	}

	public double getElementByIndex(int index1, int index2) {
		if (index1 >= 0 && index1 < this.rows && index2 >= 0 && index2 < this.rows)
			return matrix[rows][cols];
		else
			return 0;
	}

	public double[][] toArray() {
		return matrix;
	}

	public double getMaxEInSpecificCol(int cols) {
		double maxE = 0;
		for (int i = 0; i < rows; i++)
			if (matrix[i][cols-1] > maxE)
				maxE = matrix[i][cols-1];
		return maxE;
	}

	public double getMaxE() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] > maxE)
					maxE = matrix[i][j];
			}
		return maxE;
	}

	public Coordinate[] findElement(double e) {
		ArrayList<Coordinate> coArray = new ArrayList<>();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (matrix[i][j] == e)
					coArray.add(new Coordinate(j, i));
		Coordinate[] c = new Coordinate[coArray.size()];
		for (int i = 0; i < coArray.size(); i++)
			c[i] = coArray.get(i);
		return c;
	}

	public double getMinE() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] < minE)
					minE = matrix[i][j];
			}
		return minE;
	}

	public Matrix getSubMatrix(Coordinate[] c) {
		double[][] temp = new double[c[0].y][cols];
		for (int i = 0; i < c[0].y; i++)
			temp[i] = matrix[c[i].y];
		return new Matrix(temp);
	}
}
