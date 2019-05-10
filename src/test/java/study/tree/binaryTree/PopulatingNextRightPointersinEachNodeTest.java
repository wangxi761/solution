package study.tree.binaryTree;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeTest {

	@Test
	public void testConnect() {
		Stack<Integer> stack=new Stack<Integer>();
		int num=5;
		for (int i = 0; i < num; i++) {
			stack.push(i);
		}
		stack.add(0,5);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
