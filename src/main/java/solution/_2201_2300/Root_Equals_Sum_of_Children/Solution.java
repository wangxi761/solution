package solution._2201_2300.Root_Equals_Sum_of_Children;

import struct.TreeNode;

class Solution {
	public boolean checkTree(TreeNode root) {
		return root.val == root.left.val + root.right.val;
	}
}