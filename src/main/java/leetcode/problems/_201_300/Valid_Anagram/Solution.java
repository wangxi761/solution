package leetcode.problems._201_300.Valid_Anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
	public boolean isAnagram(String s, String t) {
		int[] sCount = new int[26];
		for (char c : s.toCharArray()) {
			sCount[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			sCount[c - 'a']--;
		}
		for (int i : sCount) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
	//Example 1:
	//
	//Input: s = "anagram", t = "nagaram"
	//Output: true
	@Test
	public void test1(){
		Assertions.assertTrue(isAnagram("anagram", "nagaram"));
	}
	
	//Example 2:
	//
	//Input: s = "rat", t = "car"
	//Output: false
	@Test
	public void test2(){
	    Assertions.assertFalse(isAnagram("rat", "car"));
	}
}
