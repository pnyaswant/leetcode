package com.yash.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(4);
		TreeNode node = root;
		node.left = left;
		node.right = right;
		node = left;
		TreeNode node1 = right;

		left = new TreeNode(1);
		right = new TreeNode(3);

		node.left = left;
		node.right = right;

		node = node1;

		left = new TreeNode(1);
		right = new TreeNode(3);

		node.left = left;
		node.right = right;

		SymmetricTree obj = new SymmetricTree();
		System.out.println(obj.isSymmetric1(root));

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isSymmetric(root.left, root.right);

	}

	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

		queue1.add(root);
		queue2.add(root);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (node1 == null && node2 == null)
				continue;

			if (node1 == null || node2 == null) {
				return false;
			}
			if (node1.val != node2.val) {
				return false;
			}
			queue1.add(node1.left);
			queue1.add(node1.right);
			queue2.add(node2.right);
			queue2.add(node2.left);

		}

		return true;

	}

	public boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root1 == null) {
			return true;
		}

		if (root1 != null & root2 != null && root1.val == root2.val && isSymmetric(root1.left, root2.right)
				&& isSymmetric(root1.right, root2.left)) {
			return true;
		}

		return false;

	}

}
