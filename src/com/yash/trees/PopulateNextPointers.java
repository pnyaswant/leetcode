package com.yash.trees;

public class PopulateNextPointers {

	public static void main(String[] args) {

		TreeLinkNode root = new TreeLinkNode(4);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(6);
		TreeLinkNode node = root;
		node.left = left;
		node.right = right;
		node = left;
		TreeLinkNode node1 = right;

		left = new TreeLinkNode(1);
		right = new TreeLinkNode(3);

		node.left = left;
		node.right = right;

		node = node1;

		left = new TreeLinkNode(5);
		right = new TreeLinkNode(7);

		node.left = left;
		node.right = right;

		PopulateNextPointers obj = new PopulateNextPointers();
		obj.connect(root);
		System.out.println("Done");

	}

	public void connectFullBT(TreeLinkNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null)
				root.right.next = root.next.left;
		}

		connect(root.left);
		connect(root.right);
	}

	public void connect(TreeLinkNode root) {

		if (root == null)
			return;

		if (root.left != null && root.right != null) {
			root.left.next = root.right;
			root.right.next = getNextPointerOfChild(root);
		} else if (root.left != null) {
			root.left.next = getNextPointerOfChild(root);
		} else if (root.right != null) {
			root.right.next = getNextPointerOfChild(root);
		}

		connect(root.right);
		connect(root.left);

	}

	public TreeLinkNode getNextPointerOfChild(TreeLinkNode node) {

		TreeLinkNode result = node;

		while (node.next != null && (node.next.left == null && node.next.right == null)) {
			result = node.next;
		}

		if (result.left != null) {
			return result.left;
		}

		if (result.right != null) {
			return result.right;
		}

		return result;

	}
}
