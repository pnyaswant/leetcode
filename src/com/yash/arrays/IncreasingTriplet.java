package com.yash.arrays;

public class IncreasingTriplet {

	public static void main(String[] args) {
		IncreasingTriplet triplet = new IncreasingTriplet();
		System.out.println(triplet.increasingTriplet(null));
	}

	public boolean increasingTriplet(int[] nums) {
		if (nums == null)
			return false;
		int small = Integer.MAX_VALUE;
		int large = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (small != large && large < nums[i]) {
				return true;
			}
			if (nums[i] < small) {
				large = small;
				small = nums[i];
			} else if (nums[i] < large) {
				large = nums[i];
			}
		}
		return false;
	}

}
