package study.tree.binarySearchTree;

import struct.TreeNode;

public class SearchinaBinarySearchTree {
	public TreeNode searchBST(TreeNode root, int val) {
		if(root==null) return null;
		if(root.val==val) return root;
		else if(root.val>val) return searchBST(root.left, val);
		else return searchBST(root.right, val);
		
	}
}
