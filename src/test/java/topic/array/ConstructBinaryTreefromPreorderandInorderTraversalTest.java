package topic.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructBinaryTreefromPreorderandInorderTraversalTest {

	@Test
	public void buildTree() {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		ConstructBinaryTreefromPreorderandInorderTraversal constructBinaryTreefromPreorderandInorderTraversal = new ConstructBinaryTreefromPreorderandInorderTraversal();
		constructBinaryTreefromPreorderandInorderTraversal.buildTree(preorder, inorder);
	}
}