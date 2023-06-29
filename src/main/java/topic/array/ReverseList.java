package topic.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.ListNode;

public class ReverseList {
	public ListNode reverseI(ListNode node) {
		ListNode pre = null;
		
		while (node != null) {
			ListNode next = node.next;
			node.next = pre;
			
			pre = node;
			node = next;
		}
		return pre;
	}
	
	public ListNode reverse(ListNode node) {
		return reverse(node, null);
	}
	
	public ListNode reverse(ListNode node, ListNode pre) {
		if (node == null) {
			return pre;
		}
		ListNode next = node.next;
		node.next = pre;
		return reverse(next, node);
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(ListNode.create(1, 2, 3), reverse(ListNode.create(3, 2, 1)));
		Assertions.assertEquals(ListNode.create(1, 2, 3, 4, 5, 6), reverse(ListNode.create(6, 5, 4, 3, 2, 1)));
		Assertions.assertEquals(ListNode.create(1), reverse(ListNode.create(1)));
	}
}
