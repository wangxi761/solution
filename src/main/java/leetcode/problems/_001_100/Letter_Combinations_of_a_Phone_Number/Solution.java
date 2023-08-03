package leetcode.problems._001_100.Letter_Combinations_of_a_Phone_Number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<String> letterCombinations(String digits) {
		char[][] ch = {
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
		};
		Deque<String> deque = new LinkedList<>();
		for (char c : digits.toCharArray()) {
			if (deque.isEmpty()) {
				deque.offerFirst("");
			}
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				String s = deque.pollLast();
				for (char b : ch[c - '2']) {
					deque.offerFirst(s + b);
				}
			}
		}
		return new ArrayList<>(deque);
	}
	
	@Test
	public void test(){
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));
	}
}