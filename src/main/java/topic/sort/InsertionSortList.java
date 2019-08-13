package topic.sort;

import struct.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode res = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = null;
			res = insert(res, head);
			head = next;
		}
		return res;
	}
	
	public ListNode insert(ListNode head, ListNode node) {
		if (head == null) return node;
		if (node.val < head.val) {
			node.next = head;
			return node;
		}
		ListNode first = head;
		while (head != null) {
			if (node.val < head.val) {
				ListNode next = head.next;
				head.next = node;
				node.next = next;
				break;
			}
			if (head.next == null) {
				head.next = node;
				break;
			}
			head = head.next;
		}
		return first;
	}
}
