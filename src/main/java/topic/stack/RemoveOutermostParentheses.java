package topic.stack;

import java.util.Stack;

public class RemoveOutermostParentheses {
	public String removeOuterParentheses(String S) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int pre = 0;
		for (int i = 0; i < S.length(); i++) {
			if (stack.isEmpty()) {
				String str = i - 1 > pre + 1 ? S.substring(pre + 1, i - 1) : "";
				sb.append(str);
				pre = i;
			}
			char c = S.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				stack.pop();
			}
		}
		sb.append(S.substring(pre + 1, S.length() - 1));
		return sb.toString();
	}
}
