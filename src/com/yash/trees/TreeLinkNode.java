package com.yash.trees;

public class TreeLinkNode {
	
	public int val;
	public TreeLinkNode left;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeLinkNode [val=");
		builder.append(val);
		builder.append(", left=");
		builder.append(left);
		builder.append(", right=");
		builder.append(right);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}

	public TreeLinkNode right;
	public TreeLinkNode next;
	
	public TreeLinkNode(int x) {
		val = x;
	}

}
