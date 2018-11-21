package com.yash.arrays;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = {};
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int start = 0;
		int end = nums1.length;

		int partitionLength = (nums1.length + nums2.length + 1) / 2;
		while (start <= end) {
			int partX = (start + end) / 2;
			int partY = partitionLength - partX;

			int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
			int xRight = partX == nums1.length ? Integer.MAX_VALUE : nums1[partX];

			int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
			int yRight = partY == nums2.length ? Integer.MAX_VALUE : nums2[partY];

			if (xLeft <= yRight && yLeft <= xRight) {
				if ((nums1.length + nums2.length) % 2 == 0) {
					return ((double) (Integer.max(xLeft, yLeft) + Integer.min(xRight, yRight))) / 2;
				} else {
					return Integer.max(xLeft, yLeft);
				}
			} else if (xLeft > yRight) {
				end = partX - 1;
			} else {
				start = partX + 1;
			}

		}
		throw new IllegalArgumentException();
	}

}
