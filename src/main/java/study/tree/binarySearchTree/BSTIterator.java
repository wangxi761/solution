package study.tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import struct.TreeNode;

public class BSTIterator {
	
	private Queue<Integer> queue=new LinkedList<>();
	
	public BSTIterator(TreeNode root) {
		inOrder(root);
	}
	
	public int next() {
		return queue.poll();
	}

	public boolean hasNext() {
		return queue.size()>0;
	}
	
	public void inOrder(TreeNode node) {
		if(node==null)
			return;
		inOrder(node.left);
		queue.offer(node.val);
		inOrder(node.right);
	}
}
