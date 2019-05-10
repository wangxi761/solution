package study.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

import struct.TreeNode;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		recursive(list, root);
		return list;
	}
	public void recursive(List<Integer> list, TreeNode root) {
		if(root==null) return;
		if(root.left!=null) recursive(list, root.left);
		list.add(root.val);
		if(root.right!=null) recursive(list, root.right);
	}
}
