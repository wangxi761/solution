package solution._11_20;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidParentheses {
	@Test
	public void test() throws Exception {
		assertEquals(true, isValid("[]{()}"));
	}
	
	public boolean isValid(String s) {
		Map<Character, Character> map=new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> stack=new Stack<>();
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if(stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			if(map.containsKey(stack.peek())&&map.get(stack.peek())==c) {
				stack.pop();
				continue;
			}else {
				stack.push(c);
			}
		}
		return stack.isEmpty()?true:false;
	}
}
