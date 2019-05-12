package study.tree.binaryTree;

import java.util.*;

import org.junit.Test;
import struct.Node;

public class PopulatingNextRightPointersinEachNodeTest {
	PopulatingNextRightPointersinEachNode test = new PopulatingNextRightPointersinEachNode();
	@Test
	public void testConnect() {
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node3 = new Node(3, node6, node7, null);
		Node node2 = new Node(2, node4, node5, null);
		Node root = new Node(1, node2, node3, null);

		List<Integer> list = new ArrayList<>();

		Queue<Node> nodes = new LinkedList<>();
		nodes.offer(root);
		test.bfsByQueue(nodes, list);

		System.out.println(list);


	}

}
