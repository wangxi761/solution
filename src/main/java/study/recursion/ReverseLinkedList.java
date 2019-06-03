package study.recursion;

import struct.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode node = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	
}
