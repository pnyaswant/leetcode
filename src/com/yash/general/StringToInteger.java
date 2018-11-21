package com.yash.general;

public class StringToInteger {

	public static void main(String[] args) {

		StringToInteger atoi = new StringToInteger();
		System.out.println(atoi.myAtoi("91283472332"));

	}

	public int myAtoi(String str) {

		char[] arr = str.toCharArray();

		boolean numStarted = false;
		int result = 0;
		boolean positive = true;

		for (int i = 0; i < arr.length; i++) {

			if (numStarted) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					if ((positive && (result > Integer.MAX_VALUE / 10
							|| (result == Integer.MAX_VALUE / 10 && arr[i] - '0' > Integer.MAX_VALUE % 10)))
							|| (!positive && (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10
									&& (arr[i] - '0') > -(Integer.MIN_VALUE % 10))))) {
						return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
					}
					if (positive) {
						result = 10 * result + arr[i] - '0';
					} else {
						result = 10 * result - (arr[i] - '0');
					}

				} else {
					return result;
				}

			} else {
				if (arr[i] == ' ') {
					continue;
				} else if (arr[i] == '+') {
					numStarted = true;
				} else if (arr[i] == '-') {
					numStarted = true;
					positive = false;

				} else if (arr[i] >= '0' && arr[i] <= '9') {
					numStarted = true;
					result = 10 * result + arr[i] - '0';
					result = positive ? result : -result;

				} else {
					return 0;
				}

			}
		}
		return result;

	}
}
