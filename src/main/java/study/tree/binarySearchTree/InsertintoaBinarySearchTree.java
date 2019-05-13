package study.tree.binarySearchTree;

import struct.TreeNode;

public class InsertintoaBinarySearchTree {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		else if (root.val > val)
			root.left = insertIntoBST(root.left, val);
		else if (root.val < val)
			root.right = insertIntoBST(root.right, val);
		return root;
	}
}
