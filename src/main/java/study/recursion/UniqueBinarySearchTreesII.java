package study.recursion;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		return generate(1, n);
	}
	
	public List<TreeNode> generate(int begin, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (begin > end) {
			result.add(null);
		}
		for (int i = begin; i <= end; i++) {
			List<TreeNode> lefts = generate(begin, i - 1);
			List<TreeNode> rights = generate(i + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					result.add(node);
				}
			}
		}
		return result;
	}
}
