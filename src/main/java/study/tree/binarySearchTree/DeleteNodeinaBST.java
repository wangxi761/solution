package study.tree.binarySearchTree;

import struct.TreeNode;

public class DeleteNodeinaBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode cur=root,last=null;
		while(cur!=null) {
			if(cur.val==key) {
				if(cur.left==null&&cur.right==null) {
					last=null;
				}else if(cur.left!=null&&cur.right!=null) {
					TreeNode maxNode=cur.left;
					int lMax=Integer.MIN_VALUE;
					while(maxNode!=null) {
						lMax=Math.max(lMax, maxNode.val);
						maxNode=cur.right;
					}
					
				}else {
					TreeNode t=cur.left==null?cur.right:cur.left;
					if(last.val>t.val) last.left=t;
					else last.right=t;
				}
			}else if(cur.val>key) {
				last=cur;
				cur=cur.left;
			}else if(cur.val<key) {
				last=cur;
				cur=cur.right;
			}
		}
		return root;
	}
}
