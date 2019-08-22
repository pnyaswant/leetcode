package com.yash.arrays;

import java.util.Arrays;

public class NumberOfIslands2 {
	private int[] rankArray;

	int size, cols, rows;

	public NumberOfIslands2(int m, int n) {
		rankArray = new int[m * n];
		this.size = 0;
		this.cols = n;
		this.rows = m;
		Arrays.fill(rankArray, rows * cols + 1);
	}

	public int add(int x, int y) {
		int index = getIndex(x, y);
		rankArray[index] = -1;
		size++;
		int[] neighbors = getNeighbors(x, y);
		for (int n : neighbors) {
			if (n < 0 || rankArray[n] == rows * cols + 1) {
				continue;
			}
			union(index, n);
		}
		return size;
	}

	private int getIndex(int x, int y) {
		return x * cols + y;
	}

	// left, right, down, up
	private int[] getNeighbors(int x, int y) {
		int[] neighbors = new int[4];
		neighbors[0] = x - 1 >= 0 ? getIndex(x - 1, y) : -1;
		neighbors[1] = x + 1 < rows ? getIndex(x + 1, y) : -1;
		neighbors[2] = y - 1 >= 0 ? getIndex(x, y - 1) : -1;
		neighbors[3] = y + 1 < cols ? getIndex(x, y + 1) : -1;
		return neighbors;
	}

	private void union(int index1, int index2) {
		int root1 = find(index1);
		int root2 = find(index2);
		if (root1 == root2) {
			size--;
			return;
		}
		if (rankArray[root2] < rankArray[root1]) {
			rankArray[root1] = root2;
			size--;
		} else {
			if (rankArray[root1] == rankArray[root2]) {
				rankArray[root1]--;
			}
			rankArray[root2] = root1;
			size--;
		}
	}

	private int find(int index) {
		if (rankArray[index] < 0) {
			return index;
		}
		int root = find(rankArray[index]);
		rankArray[index] = root;
		return root;
	}

	public static void main(String[] args) throws Exception {
		NumberOfIslands2 obj = new NumberOfIslands2(3, 3);
		System.out.println(obj.add(1, 1));
		System.out.println(obj.add(2, 2));
		System.out.println(obj.add(1, 2));
	}
}
