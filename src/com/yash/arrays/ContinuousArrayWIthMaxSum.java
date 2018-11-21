package com.yash.arrays;

public class ContinuousArrayWIthMaxSum {

	public static void main(String[] args) {
		
		ContinuousArrayWIthMaxSum obj = new ContinuousArrayWIthMaxSum();
		System.out.println(obj.getMaxSumContinuousArray(new int[] {-1}));
	}
	
	private int getMaxSumContinuousArray(int[] arr) {
		
		int max = arr[0];
		
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
	

}
