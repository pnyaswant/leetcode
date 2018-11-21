package com.yash.arrays;

import java.util.Stack;

public class NextLargerNumber {

	public static void main(String[] args) {
		NextLargerNumber obj = new NextLargerNumber();
		int res[] = obj.nextLargerNumber(new int[] { 1, 3, 2, 4 });
		for(int i = 0; i < res.length ; i++) {
			System.out.println(res[i]);
		}
	}

	private int[] nextLargerNumber(int[] input) {
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[input.length];
		stack.add(0);
		for (int i = 1; i < input.length; i++) {
			if (stack.isEmpty() || input[stack.peek()] > input[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
					res[stack.pop()] = input[i];
				}
				stack.push(i);
			}

		}
		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}
		return res;
	}

}
