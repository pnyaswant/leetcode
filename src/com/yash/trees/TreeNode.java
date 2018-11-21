package com.yash.trees;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeNode [val=");
		builder.append(val);
		builder.append("]");
		return builder.toString();
	}

}
