package topic.string;

import struct.TreeNode;

public class ConstructStringFromBinaryTree {
	public String tree2str(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		recursive(t, sb);
		return sb.toString();
	}
	
	public void recursive(TreeNode t, StringBuilder sb) {
		if (t == null) {
			return;
		} else {
			sb.append(t.val);
			if (t.left != null || t.right != null) {
				sb.append('(');
				recursive(t.left, sb);
				sb.append(')');
			}
			if (t.right != null) {
				sb.append('(');
				recursive(t.right, sb);
				sb.append(')');
			}
		}
	}
	
	public String tree2str1(TreeNode t) {
		if (t == null) {
			return "";
		} else {
			String subLeft = t.left == null && t.right == null ? "" : "(" + tree2str1(t.left) + ")";
			String subRight = t.right == null ? "" : "(" + tree2str1(t.right) + ")";
			return t.val + subLeft + subRight;
		}
	}
}
