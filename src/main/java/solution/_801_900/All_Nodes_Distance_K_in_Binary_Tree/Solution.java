package solution._801_900.All_Nodes_Distance_K_in_Binary_Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		buildGraph(root, null, graph);
		
		List<Integer> res = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(target.val);
		visited.add(target.val);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer cur = queue.poll();
				if (count == k) {
					res.add(cur);
					continue;
				}
				Set<Integer> neighbor = graph.get(cur);
				if (neighbor == null) continue;
				for (Integer n : neighbor) {
					if (!visited.contains(n)) {
						visited.add(n);
						queue.add(n);
					}
				}
			}
			count++;
		}
		return res;
	}
	
	public void buildGraph(TreeNode node, TreeNode parent, Map<Integer, Set<Integer>> graph) {
		if (node == null) return;
		if (parent != null) {
			graph.computeIfAbsent(node.val, k -> new HashSet<>()).add(parent.val);
			graph.computeIfAbsent(parent.val, k -> new HashSet<>()).add(node.val);
		}
		buildGraph(node.left, node, graph);
		buildGraph(node.right, node, graph);
	}
	
	
	@Test
	public void test() {
		TreeNode root3 = TreeNode.create(0, 2, 1, null, null, 3);
		TreeNode node3 = TreeNode.get(root3, 3);
		Assertions.assertEquals(List.of(2), distanceK(root3, node3, 3));
		
		
		TreeNode root2 = TreeNode.create(0, 1, null, 3, 2);
		TreeNode node2 = TreeNode.get(root2, 2);
		Assertions.assertEquals(List.of(1), distanceK(root2, node2, 1));
		
		//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
		//Output: [7,4,1]
		TreeNode root = TreeNode.create(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
		TreeNode node = TreeNode.get(root, 5);
		Assertions.assertEquals(Stream.of(7, 4, 1).sorted().collect(Collectors.toList()), distanceK(root, node, 2).stream().sorted()
		                                                                                                          .collect(Collectors.toList()));
		
		//Input: root = [1], target = 1, k = 3
		//Output: []
		TreeNode root1 = TreeNode.create(1);
		TreeNode node1 = TreeNode.get(root1, 1);
		Assertions.assertEquals(Stream.of().sorted().collect(Collectors.toList()), distanceK(root1, node1, 3).stream().sorted().collect(Collectors.toList()));
	}
	
}