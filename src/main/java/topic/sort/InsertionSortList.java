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
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		pre.next = head;
		ListNode first = pre;
		while (head != null) {
			if (node.val < head.val) {
				pre.next = node;
				node.next = head;
				break;
			}
			if (head.next == null) {
				head.next = node;
				break;
			}
			head = head.next;
			pre = pre.next;
		}
		return first.next;
	}
}
