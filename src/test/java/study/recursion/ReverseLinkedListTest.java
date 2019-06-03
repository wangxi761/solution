package study.recursion;

import org.junit.Test;
import struct.ListNode;

public class ReverseLinkedListTest {
	ReverseLinkedList test = new ReverseLinkedList();
	
	@Test
	public void reverseList() {
		ListNode head = ListNode.create(1, 2, 3, 4, 5);
		test.reverseList(head);
	}
}