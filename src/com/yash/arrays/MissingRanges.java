package com.yash.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		int[] a = { 1, 3, 50, 75 };
		MissingRanges obj = new MissingRanges();
		System.out.println(obj.findMissingRanges(a, 0, 99));
	}

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> result = new ArrayList<String>();
		if (lower == Integer.MAX_VALUE) {
			return result;
		}
		int current = lower;
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				continue;
			}

			if (nums[i] == current) {
				current++;
			} else {
				result.add(getRange(current, nums[i] - 1));
				if (nums[i] == Integer.MAX_VALUE) {
					return result;
				}
				current = nums[i] + 1;
			}
		}

		return result;
	}

	private String getRange(int n1, int n2) {
		return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}

}
