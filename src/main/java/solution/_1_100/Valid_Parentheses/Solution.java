package solution._1_100.Valid_Parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	public boolean isValid(String s) {
		Map<Character, Character> valid = new HashMap<>();
		valid.put('(', ')');
		valid.put('[', ']');
		valid.put('{', '}');
		
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			if (valid.getOrDefault(stack.peek(), '0') == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	
	
	@Test
	public void test() {
		Assertions.assertEquals(true, isValid("()"));
		Assertions.assertEquals(true, isValid("()[]{}"));
		Assertions.assertEquals(false, isValid("(]"));
	}
}