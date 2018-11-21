package com.yash.arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] { 1, 3 }, 0));
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return search(nums, target, 0, nums.length - 1);
	}

	private int search(int[] nums, int target, int start, int end) {
		int mid = (start + end) / 2;

		if (target == nums[mid]) {
			return mid;
		}
		if (start == end) {
			return -1;
		}

		if (nums[mid] >= nums[start]) {
			if (target >= nums[start] && target < nums[mid]) {
				return search(nums, target, start, mid - 1);
			} else {
				return search(nums, target, mid + 1, end);
			}
		} else {
			if (target <= nums[end] && target > nums[mid]) {
				return search(nums, target, mid + 1, end);
			} else {
				return search(nums, target, start, mid - 1);
			}
		}

	}
}
