package leetcode.problems.reverse_linked_list;

import leetcode.struct.ListNode;

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
	public ListNode reverseList(ListNode head) {
		ListNode cur = head, pre = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public ListNode reverseListI(ListNode head) {
		ListNode last = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = last;
			last = head;
			head = next;
		}
		return last;
	}
}