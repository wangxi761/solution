package solution._1301_1400.Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		Stack<TreeNode> originStack = new Stack<>();
		Stack<TreeNode> clonedStack = new Stack<>();
		originStack.push(original);
		clonedStack.push(cloned);
		
		while (!originStack.isEmpty()) {
			TreeNode originNode = originStack.pop();
			TreeNode clonedNode = clonedStack.pop();
			if (originNode.val == target.val) {
				return clonedNode;
			}
			if (originNode.left != null) originStack.push(originNode.left);
			if (originNode.right != null) originStack.push(originNode.right);
			
			if (clonedNode.left != null) clonedStack.push(clonedNode.left);
			if (clonedNode.right != null) clonedStack.push(clonedNode.right);
		}
		return null;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(TreeNode.create(3, 6, 19), getTargetCopy(TreeNode.create(7, 4, 3, null, null, 6, 19), TreeNode.create(7, 4, 3, null, null, 6, 19), new TreeNode(3)));
		Assertions.assertEquals(TreeNode.create(7), getTargetCopy(TreeNode.create(7), TreeNode.create(7), new TreeNode(7)));
	}
}