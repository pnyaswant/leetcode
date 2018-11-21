package com.yash.arrays;

public class FindMissingPositive {

	public static void main(String[] args) {
		FindMissingPositive obj = new FindMissingPositive();
		System.out.println(obj.firstMissingPositive(new int[] { 1,1 }));

	}

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
			}

		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;

	}

}
