package solution._801_900.Buddy_Strings;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) return false;
		if (Objects.equals(s, goal)) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				if (set.contains(s.charAt(i))) {
					return true;
				}
				set.add(s.charAt(i));
			}
		}
		List<Integer> diff = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				diff.add(i);
			}
		}
		return diff.size() == 2 && Objects.equals(s.charAt(diff.get(0)), goal.charAt(diff.get(1))) && Objects.equals(s.charAt(diff.get(1)), goal.charAt(diff.get(0)));
	}
	
	@Test
	public void test() {
		Assertions.assertTrue(buddyStrings("aaaaaaabc", "aaaaaaacb"));
		Assertions.assertFalse(buddyStrings("abcd", "badc"));
		Assertions.assertFalse(buddyStrings("abcaa", "abcbb"));
		Assertions.assertTrue(buddyStrings("ab", "ba"));
		Assertions.assertFalse(buddyStrings("ab", "ab"));
		Assertions.assertTrue(buddyStrings("aa", "aa"));
	}
}