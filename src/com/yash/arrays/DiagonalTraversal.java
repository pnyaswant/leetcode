package com.yash.arrays;

public class DiagonalTraversal {

	public static void main(String[] args) {
		DiagonalTraversal obj = new DiagonalTraversal();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(obj.findDiagonalOrder(matrix));
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		
		if(matrix.length == 0 || matrix[0].length == 0) {
			return new int[]{};
		}

		boolean order = true;

		int M = matrix.length;
		int N = matrix[0].length;

		int[] result = new int[M * N];

		int top = 0, bottom = 0, left = 0, right = 0;
		int index = 0;
		for (int i = 0; i < M + N - 1; i++) {

			if (i < N) {
				top = 0;
				right = i;
			}

			if (i >= N && i < M + N - 1) {
				top = i - N + 1;
				right = N - 1;
			}

			if (i < M) {
				bottom = i;
				left = 0;
			}

			if (i >= M && i < M + N - 1) {
				bottom = M - 1;
				left = i - M + 1;
			}

			if (order) {
				while (top <= bottom && right >= left) {
					result[index++] = matrix[bottom][left];
					bottom--;
					left++;
				}

			} else {
				while (top <= bottom && right >= left) {
					result[index++] = matrix[top][right];
					top++;
					right--;
				}

			}
			order = !order;

		}
		return result;

	}

}
