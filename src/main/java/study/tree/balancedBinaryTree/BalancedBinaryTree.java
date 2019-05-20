package study.tree.balancedBinaryTree;

import struct.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(depth(root.left) - depth(root.right)) <= 1
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	public int depth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}
