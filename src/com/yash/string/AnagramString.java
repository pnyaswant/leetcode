package com.yash.string;

import java.util.ArrayList;
import java.util.List;

public class AnagramString {

	public static void main(String[] args) {
		String str = "abccbdddbac";
		String pattern = "bca";
		System.out.println(new AnagramString().anagramList(str, pattern));

	}

	public List<Integer> anagramList(String str, String pattern) {
		List<Integer> result = new ArrayList<Integer>();
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return result;
		}
		int hash[] = new int[256];
		for (char c : pattern.toCharArray()) {
			hash[c]++;
		}

		int left = 0, right = 0, count = pattern.length();
		while (right < str.length()) {
			if (hash[str.charAt(right++)]-- > 0) {
				count--;
			}

			if (count == 0) {
				result.add(left);
			}
			if (right - left == pattern.length() && hash[str.charAt(left++)]++ >= 0) {
				count++;
			}

		}
		return result;
	}

}
