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
	
	public int rec(String[] words, int[] letterCount, int[] scores, int index) {
		if (index == words.length) return 0;
		
		boolean match = match(words[index], letterCount);
		if (!match) {
			return rec(words, letterCount, scores, index + 1);
		} else {
			int score = 0;
			int[] tmp = Arrays.copyOf(letterCount, letterCount.length);
			for (char c : words[index].toCharArray()) {
				tmp[c - 'a']--;
				score += scores[c - 'a'];
			}
			
			int noUse = rec(words, letterCount, scores, index + 1);
			int use = rec(words, tmp, scores, index + 1) + score;
			return Math.max(use, noUse);
		}
	}
	
	public boolean match(String s, int[] count) {
		int[] sCount = new int[26];
		for (char c : s.toCharArray()) {
			sCount[c - 'a']++;
			if (sCount[c - 'a'] > count[c - 'a']) {
				return false;
			}
		}
		return true;
	}
	
	
	@Test
	public void test() {
		assertEquals(23, maxScoreWords(new String[]{"dog", "cat", "dad", "good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
		assertEquals(27, maxScoreWords(new String[]{"xxxz", "ax", "bx", "cx"}, new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'}, new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}));
		assertEquals(0, maxScoreWords(new String[]{"leetcode"}, new char[]{'l', 'e', 't', 'c', 'o', 'd'}, new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
		assertEquals(51, maxScoreWords(new String[]{"add", "dda", "bb", "ba", "add"}, new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'}, new int[]{3, 9, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
	}
}