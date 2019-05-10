package study.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

import struct.TreeNode;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		recursive(list, root);
		return list;
	}

	public void recursive(List<Integer> list, TreeNode root) {
		if(root==null) return;
		list.add(root.val);
		if(root.left!=null) recursive(list, root.left);
		if(root.right!=null) recursive(list, root.right);
	}
}
