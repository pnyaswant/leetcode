package com.yash.trees;

public class BSTToDLL {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(20);

		tree.left = new TreeNode(8);
		tree.right = new TreeNode(22);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(12);
		tree.left.right.left = new TreeNode(10);
		tree.left.right.right = new TreeNode(14);

		convertTODLL(tree);
		System.out.println(head);
	}

	static TreeNode head;

	static TreeNode prev ;
	private static void convertTODLL(TreeNode node) {
		if (node == null) {
			return;
		}


		convertTODLL(node.left);
		if (prev == null) {
			head = node;
		} else {
			node.left = prev;
			prev.right = node;
		}
		prev = node;

		convertTODLL(node.right);

	}

}
