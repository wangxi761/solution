package study.RecursionII;

import struct.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return recursive(root, null, null);
	}
	
	public boolean recursive(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		} else {
			return (max == null ? true : root.val < max) && (min == null ? true : root.val > min) && recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
		}
	}
}
