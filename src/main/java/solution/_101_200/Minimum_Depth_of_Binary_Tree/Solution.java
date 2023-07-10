package solution._101_200.Minimum_Depth_of_Binary_Tree;

import struct.TreeNode;

class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = minDepth(root.left);
		int r = minDepth(root.right);
		
		return (l == 0 || r == 0) ? l + r + 1 : Math.min(l, r) + 1;
	}
}