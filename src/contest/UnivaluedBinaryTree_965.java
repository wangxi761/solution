package contest;

import struct.TreeNode;

public class UnivaluedBinaryTree_965 {
	public boolean isUnivalTree(TreeNode root) {
		return re(root, root.val);
	}

	public boolean re(TreeNode root, int val) {
		boolean left=root.left==null?true:re(root.left, val);
		boolean right=root.right==null?true:re(root.right, val);
		return left&&right&&root.val==val;
	}
}
