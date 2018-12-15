package solution._31_40;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c == ')') {
				if (s1.isEmpty()) {
					max = max > s2.size() ? max : s2.size();
					s2 = new Stack<>();
					continue;
				} else {
					s2.push(s1.pop());
					s2.push(c);
				}
			} else {
				s1.push(c);
			}
		}
		if (s1.isEmpty())
			max = max > s2.size() ? max : s2.size();
		return max;
	}

	@Test
	public void test() throws Exception {
		int max = longestValidParentheses("()(()");
		System.out.println(max);
	}

}
