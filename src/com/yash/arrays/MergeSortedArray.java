package com.yash.arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		MergeSortedArray obj = new MergeSortedArray();
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int m = 3, n = 3;
		int[] nums2 = new int[] { 2, 5, 6 };

		obj.merge(nums1, m, nums2, n);
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int end = m + n - 1;

		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[end--] = nums1[m];
				m--;
			} else {
				nums1[end--] = nums2[n];
				n--;
			}
		}
		while (n >= 0) {
			nums1[end--] = nums2[n];
			n--;
		}

	}
}
