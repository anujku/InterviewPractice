package com.anuj.interview.practice.strings;

import java.io.*;

public class MatrixOperationRowColumnZero {
	private static int[][] setRowColumnZero(int[][] matrix) {
		int[][] updatedMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				updatedMatrix[i][j] = 10 ^ -99;
			}
		}
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			int[] row = matrix[rowIndex];
			if (row != null) {
				for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
					if (matrix[rowIndex][columnIndex] == 0) {
						for (int cIndex = 0; cIndex < row.length; cIndex++) {
							updatedMatrix[rowIndex][cIndex] = 0;
						}
						for (int rIndex = 0; rIndex < matrix.length; rIndex++) {
							updatedMatrix[rIndex][columnIndex] = 0;
						}
						break;
					} else {
						if (updatedMatrix[rowIndex][columnIndex] != 0) {
							updatedMatrix[rowIndex][columnIndex] = matrix[rowIndex][columnIndex];
						}
					}
				}
			}
		}
		return updatedMatrix;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter number of rows for a matrix operation");
		int rows = Integer.parseInt(reader.readLine());
		System.out.println("Please enter number of columns for a matrix operation");
		int columns = Integer.parseInt(reader.readLine());
		int[][] matrix = new int[rows][columns];
		System.out.println("Please enter row elements the matrix");
		for (int i = 0; i < rows; i++) {
			System.out.println("Please enter row " + i + " elements");
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = Integer.parseInt(reader.readLine());
			}
		}
		System.out.println("Your Matrix is : ");
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			int[] row = matrix[rowIndex];
			if (row != null) {
				for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
					System.out.print(matrix[rowIndex][columnIndex] + "\t");
				}
			}
			System.out.println();
		}
		int[][] updatedMatrix = setRowColumnZero(matrix);
		System.out.println("Updatedf Matrix is : ");
		for (int rowIndex = 0; rowIndex < updatedMatrix.length; rowIndex++) {
			int[] row = updatedMatrix[rowIndex];
			if (row != null) {
				for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
					System.out.print(updatedMatrix[rowIndex][columnIndex] + "\t");
				}
			}
			System.out.println();
		}
	}
}
