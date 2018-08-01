package com.yash.math;

public class TrailingZerosInFactorial {

	public static void main(String args[]) {

		TrailingZerosInFactorial trailingZerosInFactorial = new TrailingZerosInFactorial();
		System.out.println(trailingZerosInFactorial.trailingZeroesLogTime(1808548329));

	}

	public int trailingZeroes(int n) {
		int result = 0;

		for (int i = 5; i <= n; i = i + 5) {
			int temp = i;
			while (temp >= 5 && temp % 5 == 0) {
				temp = temp / 5;
				result++;
			}
		}
		return result;
	}

	public int trailingZeroesLogTime(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

}
