package leetcode.problems.reverse_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import leetcode.struct.ListNode;

public class SolutionTest {
	Solution solution = new Solution();
	
	@Test
	public void reversesListWithMultipleElements() {
		ListNode head = ListNode.create(1, 2, 3);
		ListNode expected = ListNode.create(3, 2, 1);
		Assertions.assertEquals(expected, solution.reverseList(head));
	}
	
	@Test
	public void handlesEmptyList() {
		ListNode head = null;
		ListNode expected = null;
		Assertions.assertEquals(expected, solution.reverseList(head));
	}
	
	@Test
	public void handlesListWithSingleElement() {
		ListNode head = new ListNode(1);
		ListNode expected = new ListNode(1);
		Assertions.assertEquals(expected, solution.reverseList(head));
	}
	
	@Test
	public void reversesListWithTwoElements() {
		ListNode head = ListNode.create(1, 2);
		ListNode expected = ListNode.create(2, 1);
		Assertions.assertEquals(expected, solution.reverseList(head));
	}
}