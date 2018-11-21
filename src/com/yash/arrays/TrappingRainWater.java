package com.yash.arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		System.out.println(obj.trappingRainWater(new int[] { 1, 3, 2, 4 }));
	}

	private int trappingRainWater(int[] input) {

		int left_max = 0;
		int right_max = 0;

		int low = 0;
		int high = input.length - 1;
		int result = 0;
		while (low < high) {
			if (input[low] < input[high]) {
				if (input[low] > left_max) {
					left_max = input[low];
				} else {
					result += left_max - input[low];
				}
				low++;

			} else {
				if (input[high] > right_max) {
					right_max = input[high] - right_max;
				} else {
					result += right_max - input[high];
				}
				high--;
			}
		}
		return result;
	}

}
