package leetcode.problems._301_400.Reverse_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public void reverseString(char[] s) {
		int i = 0, j = s.length - 1;
		while (i < j) {
			s[j] = (char) (s[j] + s[i]);
			s[i] = (char) (s[j] - s[i]);
			s[j] = (char) (s[j] - s[i]);
			i++;
			j--;
		}
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: s = ["h","e","l","l","o"]
		//Output: ["o","l","l","e","h"]
		char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
		reverseString(s1);
		Assertions.assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s1);
		
		//Example 2:
		//
		//Input: s = ["H","a","n","n","a","h"]
		//Output: ["h","a","n","n","a","H"]
		char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
		reverseString(s2);
		Assertions.assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, s2);
		
		
	}
}

