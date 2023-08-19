package leetcode.problems._501_600.Reverse_String_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public String reverseStr(String s, int k) {
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i += 2 * k) {
			int j = i + k - 1;
			if (j >= ch.length) {
				reverse(ch, i, ch.length - 1);
			} else {
				reverse(ch, i, j);
			}
		}
		return new String(ch);
	}
	
	public void reverse(char[] ch, int i, int j) {
		while (i < j) {
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
			i++;
			j--;
		}
	}
	
	@Test
	public void test() {
		Assertions.assertEquals("gfedcba", reverseStr("abcdefg", 8));
		//Example 1:
		//
		//Input: s = "abcdefg", k = 2
		//Output: "bacdfeg"
		//Example 2:
		//
		//Input: s = "abcd", k = 2
		//Output: "bacd"
		Assertions.assertEquals("bacdfeg", reverseStr("abcdefg", 2));
		Assertions.assertEquals("bacd", reverseStr("abcd", 2));
	}
}
