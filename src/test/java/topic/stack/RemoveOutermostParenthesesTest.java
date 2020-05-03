package topic.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveOutermostParenthesesTest {
	RemoveOutermostParentheses test = new RemoveOutermostParentheses();
	
	@Test
	public void removeOuterParentheses() {
		assertEquals("()()()", test.removeOuterParentheses("(()())(())"));
		assertEquals("()()()()(())", test.removeOuterParentheses("(()())(())(()(()))"));
		assertEquals("", test.removeOuterParentheses("()()"));
	}
}