package study.recursion;

import org.junit.jupiter.api.Test;
import struct.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueBinarySearchTreesIITest {
	UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
	
	@Test
	public void generateTrees() {
		List<TreeNode> nodes = test.generateTrees(0);
		
	}
}