package topic.sort;

import struct.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class SortList {
	public ListNode sortList(ListNode head) {
		Queue<ListNode> queue = new LinkedList<>();
		while (head != null) {
			if (head.next == null) {
				queue.offer(head);
				head = head.next;
			} else {
				ListNode next = head.next.next;
				if (head.val > head.next.val) {
					head.next.next = head;
					head = head.next;
				}
				head.next.next = null;
				queue.offer(head);
				head = next;
			}
		}
		while (queue.size() > 1) {
			ListNode l1 = queue.poll();
			ListNode l2 = queue.poll();
			queue.offer(merge(l1, l2));
		}
		return queue.poll();
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode head = res;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				head = head.next;
				l1 = l1.next;
			} else {
				head.next = l2;
				head = head.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			head.next = l1;
		}
		if (l2 != null) {
			head.next = l2;
		}
		return res.next;
	}
}
