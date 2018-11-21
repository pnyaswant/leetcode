package com.yash.arrays;

public class CuttingRod {

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
	}

	private static int cutRod(int[] arr, int size) {

		int res[] = new int[size + 1];
		res[0] = 0;
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < i; j++) {
				res[i] = Math.max(res[i], arr[j] + res[i - j - 1]);
			}
		}

		return res[size];
	}

}
