package study.recursion;

import struct.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = null;
		if (l1 == null && l2 == null) {
		} else if ((l1 == null && l2 != null) || (l1 != null && l2 == null)) {
			node = l1 == null ? l2 : l1;
		} else {
			node = l1.val > l2.val ? l2 : l1;
			ListNode other = l1.val > l2.val ? l1 : l2;
			node.next = mergeTwoLists(node.next, other);
		}
		return node;
	}
}
