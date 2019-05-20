package study.tree.binarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateIIITest {
	ContainsDuplicateIII test = new ContainsDuplicateIII();

	@Test
	public void containsNearbyAlmostDuplicate() {
		boolean result = test.containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647);
		boolean result1 = test.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2);
		assertEquals(false, result);
		assertEquals(true, result1);
	}
}