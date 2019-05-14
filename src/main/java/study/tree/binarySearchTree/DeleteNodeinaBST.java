package study.tree.binarySearchTree;

import struct.TreeNode;

public class DeleteNodeinaBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		else if (root.val > key)
			root.left = deleteNode(root.left, key);
		else if (root.val < key)
			root.right = deleteNode(root.right, key);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			TreeNode min=findMin(root.right);
			root.val=min.val;
			root.right=deleteNode(root.right, root.val);
		}
		return root;
	}
	public TreeNode findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
