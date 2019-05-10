package study.tree.binaryTree;

import struct.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return recursive(inorder, postorder, 0, inorder.length - 1,
				postorder.length - 1);
	}
	public TreeNode recursive(int[] inorder, int[] postorder, int instart,
			int inend, int postend) {
		if (instart > inend || postend < 0)
			return null;
		int index = 0;
		while (index < inorder.length) {
			if (inorder[index] == postorder[postend])
				break;
			index++;
		}
		TreeNode node = new TreeNode(postorder[postend]);
		node.left = recursive(inorder, postorder, instart, index - 1,
				postend - inend + index - 1);
		node.right = recursive(inorder, postorder, index + 1, inend,
				postend - 1);
		return node;
	}
}
