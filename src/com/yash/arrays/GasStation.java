package com.yash.arrays;

public class GasStation {

	public static void main(String[] args) {

		GasStation obj = new GasStation();
		int[] gas = new int[] { 1, 2, 3, 4, 5 };
		int[] cost = new int[] { 3, 4, 5, 1, 2 };
		System.out.println(obj.canCompleteCircuit(gas, cost));

	}

	public int canCompleteCircuitTimeLimitExceeded(int[] gas, int[] cost) {

		int n = gas.length;
		int[] req = new int[n];
		for (int i = 0; i < n; i++) {
			req[i] = gas[i] - cost[i];
		}

		int start = 0;
		int end = 0;

		int sum = 0;
		while (start < n) {
			sum += req[end];
			if (sum < 0) {
				while (sum < 0 && start <= end) {
					sum = sum - req[start];
					start = start + 1;

				}

			} else if (end == start - 1 && sum >= 0) {
				return start;

			}

			end = (end + 1) % n;

		}

		return -1;

	}

	public int canCompleteCircuit1(int[] gas, int[] cost) {

		int n = gas.length;
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += gas[i] - cost[i];
		}

		if (total < 0) {
			return -1;
		}
		int start = 0, tank = 0;

		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		return start;

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = gas.length - 1;
		int end = 0;
		int sum = gas[start] - cost[start];	
		while (start > end) {
			if (sum >= 0) {
				sum += gas[end] - cost[end];
				++end;
			} else {
				--start;
				sum += gas[start] - cost[start];
			}
		}
		return sum >= 0 ? start : -1;
	}

}
