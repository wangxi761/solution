package topic.string;

import struct.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		} else {
			ListNode next = head.next;
			head.next = swapPairs(head.next.next);
			next.next = head;
			return next;
		}
	}
	
	public ListNode swapPairs1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(head.next.next);
		next.next = head;
		return next;
	}
}
