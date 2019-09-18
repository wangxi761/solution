package study.link;

import org.junit.Test;
import struct.ListNode;

public class ReverseLinkedList {
	public ListNode reverse1(ListNode head) {
		ListNode first = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = first;
			first = head;
			head = next;
		}
		return first;
	}
	
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode pre = reverse(head.next);
		next.next = head;
		head.next = null;
		return pre;
	}
	
	@Test
	public void test() {
		ListNode head = ListNode.create(1, 2, 3, 4, 5);
		System.out.println(reverse(head).getList());
	}
}
