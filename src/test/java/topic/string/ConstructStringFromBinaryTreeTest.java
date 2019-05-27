package topic.string;

import org.junit.Test;
import struct.TreeNode;

public class ConstructStringFromBinaryTreeTest {
	ConstructStringFromBinaryTree tree = new ConstructStringFromBinaryTree();
	
	@Test
	public void tree2str() {
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2, null, node4);
		TreeNode node3 = new TreeNode(3);
		TreeNode root = new TreeNode(1, node2, node3);
		
		
		String s = tree.tree2str1(root);
		System.out.println(s);
	}
}