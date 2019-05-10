package study.tree.binaryTree;

import struct.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return recursive(root.left, root.right);
	}
	public boolean recursive(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left==right;
		if (left.val == right.val)
			return recursive(left.left, right.right)
					&& recursive(left.right, right.left);
		return false;
	}
}
