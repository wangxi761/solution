package study.tree.balancedBinaryTree;

import struct.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return recursive(nums, 0, nums.length-1);
	}
	
	public TreeNode recursive(int[] nums,int begin,int end) {
		if(begin>end)
			return null;
		int mid=(end-begin)/2+begin;
		TreeNode node=new TreeNode(nums[mid]);
		node.left=recursive(nums, begin, mid-1);
		node.right=recursive(nums, mid+1, end);
		return node;
	}
}
