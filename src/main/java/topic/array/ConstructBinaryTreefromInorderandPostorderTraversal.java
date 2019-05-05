package topic.array;

import struct.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return recursive(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
	}

	public TreeNode recursive(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
		if (postEnd < 0 || inStart > inEnd) return null;
		TreeNode node = new TreeNode(postorder[postEnd]);

		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (postorder[postEnd] == inorder[i])
				index = i;
		}

		node.left = recursive(postEnd - inEnd + index - 1, inStart, index - 1, postorder, inorder);
		node.right = recursive(postEnd - 1, index + 1, inEnd, postorder, inorder);
		return node;
	}
}
