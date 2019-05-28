package topic.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveOutermostParenthesesTest {
	RemoveOutermostParentheses test = new RemoveOutermostParentheses();
	
	@Test
	public void removeOuterParentheses() {
		assertEquals("()()()", test.removeOuterParentheses("(()())(())"));
		assertEquals("()()()()(())", test.removeOuterParentheses("(()())(())(()(()))"));
		assertEquals("", test.removeOuterParentheses("()()"));
	}
}