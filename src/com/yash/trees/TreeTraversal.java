package com.yash.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(6);
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

		left = new TreeNode(5);
		right = new TreeNode(7);

		node.left = left;
		node.right = right;

		TreeTraversal preOrderTraversal = new TreeTraversal();

		List<Integer> result = preOrderTraversal.leftView(root);
		System.out.println(result);
	}

	public List<Integer> preorderTraversal1(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			result.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}

		}

		return result;

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		return result;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}
		return result;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				result.addFirst(root.val);
				root = root.right;
			}
			root = stack.pop();
			root = root.left;
		}
		return result;
	}

	public List<Integer> leftView(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (root == null)
			return result;
		while (root != null) {
			result.add(root.val);
			if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;
			} else {
				root = null;
			}
		}
		return result;
	}
}
