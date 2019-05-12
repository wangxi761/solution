package study.tree.binaryTree;

import java.util.*;

import struct.Node;

public class PopulatingNextRightPointersinEachNode {
	public Node connect(Node root) {
		Queue<Node> nodes = new LinkedList<>();
		nodes.offer(root);
		recursive(nodes);
		return root;
	}

	public void recursive(Queue<Node> queue) {
		if (queue.isEmpty()) return;
		int size = queue.size();
		Node last = null;
		for (int i = 0; i < size; i++) {
			Node node = queue.poll();
			if (node != null) {
				if (last != null) {
					last.next = node;
				}
				last = node;
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		recursive(queue);
	}


	public void bfsByList(List<Node> nodes, List<Integer> result) {
		List<Node> list = new ArrayList<>();
		if (list.isEmpty()) return;
		for (Node node : nodes) {
			if (node == null) continue;
			result.add(node.val);
			list.add(node.left);
			list.add(node.right);
		}
		bfsByList(list, result);
	}

	public void bfsByQueue(Queue<Node> queue, List<Integer> result) {
		if (queue.isEmpty()) return;
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			Node node = queue.poll();
			if (node != null) {
				result.add(node.val);
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		bfsByQueue(queue, result);
	}
}
