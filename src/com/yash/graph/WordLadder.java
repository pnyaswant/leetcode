package com.yash.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		String start = "hit";
		String end = "cog";

		System.out.println(wordLadder(start, end, dict));
	}

	private static int wordLadder(String start, String end, Set<String> dict) {

		Queue<QItem> queue = new LinkedList<QItem>();
		queue.add(new QItem(start, 1));

		dict.remove(start);
		while (!queue.isEmpty()) {
			QItem curr = queue.poll();

			Iterator<String> iter = dict.iterator();
			while (iter.hasNext()) {
				String word = iter.next();
				if (isAdjacent(curr.word, word)) {
					queue.add(new QItem(word, curr.len + 1));
					iter.remove();
					if (word == end) {
						return curr.len + 1;
					}
				}
			}

		}
		return 0;

	}

	private static boolean isAdjacent(String one, String two) {
		int count = 0;
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i)) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}

		return count == 1;
	}

	static class QItem {
		String word;
		int len;

		public QItem(String word, int len) {
			super();
			this.word = word;
			this.len = len;
		}
	}
}
