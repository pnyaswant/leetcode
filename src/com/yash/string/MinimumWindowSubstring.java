package com.yash.string;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String str = "ceedsforceeds";
		System.out.println(find("a", "b"));

	}

	private static String find(String str, String pattern) {
		if(pattern.length() > str.length()) {
			return "";
		}
		int[] str_count = new int[256];
		int[] pattern_count = new int[256];

		for (int i = 0; i < pattern.length(); i++) {
			pattern_count[pattern.charAt(i)]++;
		}

		int start = 0, best_start = -1;
		int best_length = Integer.MAX_VALUE;
		int currentC = 0;
		for (int i = 0; i < str.length(); i++) {
			str_count[str.charAt(i)]++;
			if (pattern_count[str.charAt(i)] != 0 && str_count[str.charAt(i)] <= pattern_count[str.charAt(i)]) {
				currentC++;
			}
			if (currentC == pattern.length()) {
				while (pattern_count[str.charAt(start)] == 0
						|| str_count[str.charAt(start)] > pattern_count[str.charAt(start)]) {
					str_count[str.charAt(start)]--;
					start++;
				}

				int len_window = i - start + 1;
				if (len_window < best_length) {
					best_length = len_window;
					best_start = start;
				}
			}

		}
		
		if(best_start == -1) {
			return "";
		}

		return str.substring(best_start, best_start + best_length);
	}

}
