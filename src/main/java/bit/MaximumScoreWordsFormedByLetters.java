package bit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumScoreWordsFormedByLetters {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
		int[] letterCount = new int[26];
		for (char c : letters) {
			letterCount[c - 'a']++;
		}
		return rec(words, letterCount, score, 0);
	}
	
	public int rec(String[] words, int[] letterCount, int[] score, int index) {
		int max = 0;
		for (int i = index; i < words.length; i++) {
			boolean valid = true;
			int curScore = 0;
			for (char c : words[i].toCharArray()) {
				letterCount[c - 'a']--;
				curScore += score[c - 'a'];
				if (letterCount[c - 'a'] < 0) valid = false;
			}
			if (valid) {
				curScore += rec(words, letterCount, score, index + 1);
				max = Math.max(max, curScore);
			}
			for (char c : words[i].toCharArray()) {
				letterCount[c - 'a']++;
				curScore=0;
			}
		}
		return max;
	}
	
	public boolean match(String s, int[] count) {
	
	}
	
	
	@Test
	public void test() {
		assertEquals(23, maxScoreWords(new String[]{"dog", "cat", "dad", "good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
		assertEquals(27, maxScoreWords(new String[]{"xxxz", "ax", "bx", "cx"}, new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'}, new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}));
		assertEquals(0, maxScoreWords(new String[]{"leetcode"}, new char[]{'l', 'e', 't', 'c', 'o', 'd'}, new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
		assertEquals(51, maxScoreWords(new String[]{"add", "dda", "bb", "ba", "add"}, new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'}, new int[]{3, 9, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
	}
}