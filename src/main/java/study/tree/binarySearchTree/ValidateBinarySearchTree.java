package study.tree.binarySearchTree;

import struct.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return recursive(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}
	public boolean recursive(TreeNode root,long max,long min) {
		if(root==null)return true;
		if(root.val>=max||root.val<=min)return false;
		return recursive(root.left, root.val, min)&&recursive(root.right, max, root.val);
	}
	
}
