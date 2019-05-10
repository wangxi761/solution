package study.tree.binaryTree;

import java.util.Stack;

import struct.Node;

public class PopulatingNextRightPointersinEachNode {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node last = null;
			for (int i = 0; i < stack.size(); i++) {
				Node node = stack.peek();
				node.next = last;
				last = stack.pop();
				if (node.left != null) {
					stack.add(0, node.left);
					stack.add(0, node.right);
				}
			}
		}
		return root;
	}

}
