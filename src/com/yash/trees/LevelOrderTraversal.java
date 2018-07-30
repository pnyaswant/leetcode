package com.yash.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

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

		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

		levelOrderTraversal.levelOrderTraversal(root);

		System.out.println(levelOrderTraversal.levelOrder(root));
		System.out.println(levelOrderTraversal.levelOrderWithOutUnnecessaryInsertion(root));
		System.out.println(levelOrderTraversal.levelOrderDFS(root));

	}

	private void levelOrderTraversal(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		}
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return result;
		}
		queue.offer(root);
		queue.offer(new TreeNode(Integer.MIN_VALUE));

		List<Integer> element = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val == Integer.MIN_VALUE) {
				result.add(element);
				queue.offer(new TreeNode(Integer.MIN_VALUE));
				node = queue.poll();
				element = new ArrayList<Integer>();
			}
			element.add(node.val);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return result;

	}

	public List<List<Integer>> levelOrderWithOutUnnecessaryInsertion(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return result;
		}
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> element = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}

				element.add(queue.poll().val);
			}
			result.add(element);
		}
		return result;

	}

	public List<List<Integer>> levelOrderDFS(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		levelOrderDFSRecc(result, root, 0);
		return result;

	}

	private void levelOrderDFSRecc(List<List<Integer>> result, TreeNode root, int height) {
		if (root == null)
			return;
		if (result.size() <= height) {
			result.add(new LinkedList<Integer>());
		}

		result.get(height).add(root.val);
		levelOrderDFSRecc(result, root.left, height + 1);
		levelOrderDFSRecc(result, root.right, height + 1);

	}
}
