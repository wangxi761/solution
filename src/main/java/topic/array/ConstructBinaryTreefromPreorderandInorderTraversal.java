package topic.array;

import struct.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return recursive(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode recursive(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart >= preorder.length || inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (preorder[preStart] == inorder[i])
				index = i;
		}
		node.left = recursive(preStart + 1, inStart, index - 1, preorder, inorder);
		node.right = recursive(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
		return node;
	}
}
