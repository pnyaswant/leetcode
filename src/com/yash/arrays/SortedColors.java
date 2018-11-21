package com.yash.arrays;

public class SortedColors {

	public static void main(String[] args) {

		SortedColors obj = new SortedColors();
		int[] arr = new int[] { 2 };
		obj.sortColors(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public void sortColors(int[] nums) {
		int n = nums.length;

		int j = 0, k = n - 1;
		for (int i = 0; i <= k; i++) {
			if (nums[i] == 0)
				swap(i, j++, nums);
			else if (nums[i] == 2)
				swap(i--, k--, nums);
		}
	}

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

}
