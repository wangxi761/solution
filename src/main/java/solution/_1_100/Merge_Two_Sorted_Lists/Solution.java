package solution._1_100.Merge_Two_Sorted_Lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.ListNode;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(0);
		ListNode pre = head;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				head.next = list1;
				list1 = list1.next;
			} else {
				head.next = list2;
				list2 = list2.next;
			}
			head = head.next;
		}
		if (list1 != null) {
			head.next = list1;
		}
		if (list2 != null) {
			head.next = list2;
		}
		return pre.next;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(ListNode.create(1, 1, 2, 3, 4, 4), mergeTwoLists(ListNode.create(1, 2, 4), ListNode.create(1, 3, 4)));
		Assertions.assertEquals(ListNode.create(), mergeTwoLists(ListNode.create(), ListNode.create()));
		Assertions.assertEquals(ListNode.create(0), mergeTwoLists(ListNode.create(), ListNode.create(0)));
	}
}