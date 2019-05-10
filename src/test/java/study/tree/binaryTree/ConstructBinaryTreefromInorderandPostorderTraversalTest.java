package study.tree.binaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

import struct.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversalTest {

	@Test
	public void testBuildTree() {
		int[] inorder= {9,3,15,20,7};
		int[] postorder= {9,15,7,20,3};
		ConstructBinaryTreefromInorderandPostorderTraversal test=new ConstructBinaryTreefromInorderandPostorderTraversal();
		TreeNode buildTree = test.buildTree(inorder, postorder);
	}

}
