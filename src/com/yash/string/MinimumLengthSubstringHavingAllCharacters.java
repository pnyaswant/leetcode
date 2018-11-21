package com.yash.string;

public class MinimumLengthSubstringHavingAllCharacters {
	public static void main(String[] args) {

		String str = "ceedsforceeds";
		System.out.println(find(str));

	}

	private static String find(String str) {
		boolean[] visited = new boolean[256];
		int dist_count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (visited[str.charAt(i)] == false) {
				dist_count++;
			}
			visited[str.charAt(i)] = true;
		}

		int start = 0, best_start = 0;
		int best_length = Integer.MAX_VALUE;
		int currentC = 0;
		int current_count[] = new int[256];
		for (int i = 0; i < str.length(); i++) {
			current_count[str.charAt(i)]++;
			if (current_count[str.charAt(i)] == 1) {
				currentC++;
			}
			if (currentC == dist_count) {
				while (current_count[str.charAt(start)] > 1) {
					current_count[str.charAt(start)]--;
					start++;
				}

				int len_window = i - start + 1;
				if (len_window < best_length) {
					best_length = len_window;
					best_start = start;
				}
			}

		}

		return str.substring(best_start, best_start + best_length);
	}

}
