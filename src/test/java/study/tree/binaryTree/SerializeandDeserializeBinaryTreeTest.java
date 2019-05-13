package study.tree.binaryTree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import struct.TreeNode;

public class SerializeandDeserializeBinaryTreeTest {
	SerializeandDeserializeBinaryTree test=new SerializeandDeserializeBinaryTree();
	@Test
	public void testSerialize() {
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		TreeNode node2=new TreeNode(2,node4,node5);
		TreeNode node3=new TreeNode(3,node6,null);
		TreeNode root=new TreeNode(1,node2,null);
		
		String serialize = test.serialize(null);
		System.out.println(serialize);
		TreeNode deserialize = test.deserialize(serialize);
		String serialize2 = test.serialize(deserialize);
		System.out.println(serialize2);
		
	}
	

}
