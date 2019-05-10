package study.tree.binaryTree;

import struct.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return recursive(inorder, preorder, 0, inorder.length-1, 0);
	}
	public TreeNode recursive(int[] inorder, int[] preorder, int instart,
			int inend, int prestart) {
		if (prestart >= preorder.length || instart > inend) {
			return null;
		}
		int index = 0;
		while (index < inorder.length) {
			if (preorder[prestart] == inorder[index])
				break;
			index++;
		}
		TreeNode node = new TreeNode(preorder[prestart]);
		node.left = recursive(inorder, preorder, instart, index - 1,
				prestart + 1);
		node.right = recursive(inorder, preorder, index + 1, inend,
				prestart + index - instart + 1);
		return node;
	}
}
