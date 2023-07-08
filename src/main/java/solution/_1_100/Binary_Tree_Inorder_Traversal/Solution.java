package solution._1_100.Binary_Tree_Inorder_Traversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;


class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		return list;
	}
	
	public void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
	
	@Test
	public void test() {
//		Input: root = [1,null,2,3]
//		Output: [1,3,2]
		Assertions.assertEquals(List.of(1, 3, 2), inorderTraversal(TreeNode.create(1, null, 2, 3)));
	}
}

