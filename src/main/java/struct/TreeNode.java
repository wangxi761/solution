package struct;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Stack;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) {
		val = x;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static TreeNode create(Integer... nums) {
		if (nums == null) return null;
		TreeNode[] treeNodes = new TreeNode[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == null) continue;
			treeNodes[i] = new TreeNode(nums[i]);
			if (i == 0) continue;
			if (i % 2 != 0) {
				treeNodes[(i - 1) / 2].left = treeNodes[i];
			} else {
				treeNodes[(i - 2) / 2].right = treeNodes[i];
			}
		}
		return treeNodes[0];
	}
	
	
	@Override
	public String toString() {
		return print(new StringBuilder(), "", true).toString();
	}
	
	private StringBuilder print(StringBuilder builder, String prefix, boolean isTail) {
		builder.append(prefix).append(isTail ? "└── " : "├── ").append(val).append(System.lineSeparator());
		if (left != null) {
			left.print(builder, prefix + (isTail ? "    " : "│   "), right == null);
		} else if (right != null) {
			builder.append(prefix).append(isTail ? "    " : "│   ").append("├── ").append("null").append(System.lineSeparator());
		}
		if (right != null) {
			right.print(builder, prefix + (isTail ? "    " : "│   "), true);
		}
		return builder;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeNode treeNode = (TreeNode) o;
		return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(val, left, right);
	}
	
}