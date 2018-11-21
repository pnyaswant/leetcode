package com.yash.math;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations obj = new LetterCombinations();
		System.out.println(obj.letterCombinations(""));
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits == null || digits.isEmpty()) {
			return result;
		}
		char[][] phone = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

		String temp = "";
		letterCombinations(digits, 0, temp, result, phone);
		return result;

	}

	private void letterCombinations(String digits, int i, String temp, List<String> result, char[][] phone) {
		if (i == digits.length()) {
			result.add(temp);
			return;
		}
		for (char ch : phone[digits.charAt(i) - '2']) {
			temp += ch;
			letterCombinations(digits, i + 1, temp, result, phone);
			temp = temp.substring(0, temp.length() - 1);
		}

		return;
	}

}
