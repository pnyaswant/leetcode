package com.yash.arrays;

public class NoOfIslands {

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 } };
		int[][] matrix = { { 1, 1, 0,0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0,1,1 } };
		System.out.println(new NoOfIslands().noOfIslands(matrix));
	}

	private int noOfIslands(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = -1;
					noOfIslands(grid, i, j + 1);
					noOfIslands(grid, i + 1, j);
					noOfIslands(grid, i, j - 1);
					noOfIslands(grid, i - 1, j);
					result++;
				}
			}
		}
		return result;
	}

	private void noOfIslands(int[][] matrix, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0 || matrix[i][j] == -1) {
			return;
		} else {
			matrix[i][j] = -1;
			noOfIslands(matrix, i, j + 1);
			noOfIslands(matrix, i + 1, j);
			noOfIslands(matrix, i, j - 1);
			noOfIslands(matrix, i - 1, j);
		}
	}

}
