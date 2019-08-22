package com.yash.arrays;

public class DifferenceTwoNumbersArrays {

	public static void main(String[] args) {

		diff(new int[] { 2, 3, 4, 6 }, new int[] { 1, 3, 15 }, 5);
		diff(new int[] { 2, 3, 4, 6 }, new int[] { 3 }, -1);
	}

	public static void diff(int[] arr1, int[] arr2, int k) {
		int l1 = 0, l2 = 0, e1 = arr1.length - 1, e2 = arr2.length - 1;
		while (l1 <= e1 || l2 <= e2) {
			if (arr1[e1] - arr2[l2] == k || arr1[e1] - arr2[l2] == -k) {
				System.out.println(arr1[e1] + ":" + arr2[l2]); return; }
			if (arr2[e2] - arr1[l1] == k || arr2[e2] - arr1[l1] == -k) {
				System.out.println(arr2[e2] + ":" + arr1[l1]); return; }
			if (arr1[e1] - arr2[e2] == k || arr1[e1] - arr2[e2] == -k) {
				System.out.println(arr1[e1] + ":" + arr2[e2]); return; }
			if (arr2[l2] - arr1[l1] == k || arr2[l2] - arr1[l1] == -k) {
				System.out.println(arr2[l2] + ":" + arr1[l1]); return; }
			if (arr1[l1] < arr2[l2]) {
				if (arr2[l2] - arr1[l1] > k) {
					l1++;
				} else if (arr1[e1] - arr2[l2] > k) {
					l2++;
				}
			} else if (arr1[l1] > arr2[l2]) {
				if (arr1[l1] - arr2[l2] > k) {
					l2++;
				} else if (arr2[e2] - arr1[l1] > k) {
					l1++;
				}
			} else if (arr1[e1] < arr2[e2]) {
				if (arr2[e2] - arr1[e1] > k) {
					e2--;
				} else if (arr1[e1] - arr2[l2] < k) {
					e1--;
				}
			} else if (arr1[e1] > arr2[e2]) {
				if (arr1[e1] - arr2[e2] > k) {
					e1--;
				} else if (arr2[e2] - arr1[l1] < k) {
					e2--;
				}
			}
		}

	}

}
