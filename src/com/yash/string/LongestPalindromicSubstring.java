package com.yash.string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		System.out.println(obj.longestPalindrome("trrt"));
	}

	public String longestPalindrome(String s) {

		if (s == null || s.isEmpty())
			return s;
		int low = 0;
		int maxLen = 1;

		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;

		}

		for (int i = 1; i < s.length(); i++) {

			for (int j = 0; j + i < s.length(); j++) {
				if (s.charAt(j) == s.charAt(j + i)) {
					if (i == 1) {
						dp[j][j + i] = 1;
						low = j;
						maxLen = j + i + 1;
					} else if (dp[j + 1][j + i - 1] == 1) {
						dp[j][j + i] = 1;
						low = j;
						maxLen = j + i + 1;
					}
				}
			}

		}
		return s.substring(low, maxLen);

	}

	private int lo, maxLen;

	public String longestPalindromeFaster(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}

}
