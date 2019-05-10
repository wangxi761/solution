package study.tree.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import struct.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		recursive(result, Arrays.asList(root));
		return result;
	}
	public void recursive(List<List<Integer>> result, List<TreeNode> nodes) {
		if (nodes.isEmpty())
			return;
		List<Integer> list = new ArrayList<>();
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (TreeNode i : nodes) {
			if (i == null)
				continue;
			newNodes.add(i.left);
			newNodes.add(i.right);
		}
		if (list.size() > 0)
			result.add(list);
		recursive(result, newNodes);
	}
}
