package study.tree.binaryTree;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import struct.TreeNode;

public class SerializeandDeserializeBinaryTree {
	private static final String SPLITER = ",";
	private static final String X = "X";

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					sb.append(X)
							.append(SPLITER);
				} else {
					sb.append(node.val)
							.append(SPLITER);
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		String[] split = data.split(SPLITER);
		Queue<TreeNode> queue = new LinkedList<>();
		if (split.length == 0 || X.equals(split[0]))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(split[0]));
		queue.offer(root);
		for (int i = 1; i < split.length; i++) {
			TreeNode node = queue.poll();
			if (!X.equals(split[i])) {
				node.left = new TreeNode(Integer.valueOf(split[i]));
				queue.offer(node.left);
			}
			if (!X.equals(split[++i])) {
				node.right = new TreeNode(Integer.valueOf(split[i]));
				queue.offer(node.right);
			}
		}
		return root;
	}

}
