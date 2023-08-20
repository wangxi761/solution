package leetcode.problems._101_200.Reverse_Words_in_a_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public String reverseWords(String s) {
		char[] ch = s.toCharArray();
		int fast = 0, slow = 0;
//		while (fast < s.length() && slow < s.length()) {
//			while (fast < s.length() && ch[fast] == ' ') {
//				fast++;
//			}
//			if (fast < s.length() && slow != 0) {
//				ch[slow++] = ' ';
//			}
//			while (fast < s.length() && ch[fast] != ' ') {
//				ch[slow++] = ch[fast++];
//			}
//		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				continue;
			}
			if (slow != 0) {
				ch[slow++] = ' ';
			}
			while (i < ch.length && ch[i] != ' ') {
				ch[slow++] = ch[i++];
			}
		}
		
		reverse(ch, 0, slow - 1);
		int left = 0, right = 0;
		while (right < slow) {
			while (right < slow && ch[right] != ' ') {
				right++;
			}
			reverse(ch, left, right - 1);
			right++;
			left = right;
		}
		return new String(ch, 0, slow);
	}
	
	public void reverse(char[] ch, int i, int j) {
		while (i < j) {
			char t = ch[i];
			ch[i++] = ch[j];
			ch[j--] = t;
		}
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: s = "the sky is blue"
		//Output: "blue is sky the"
		Assertions.assertEquals("blue is sky the", reverseWords("  the   sky is blue"));
		//Example 2:
		//
		//Input: s = "  hello world  "
		//Output: "world hello"
		//Explanation: Your reversed string should not contain leading or trailing spaces.
		Assertions.assertEquals("world hello", reverseWords("  hello world  "));
		//Example 3:
		//
		//Input: s = "a good   example"
		//Output: "example good a"
		//Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
		Assertions.assertEquals("example good a", reverseWords("a good   example"));
	}
}

