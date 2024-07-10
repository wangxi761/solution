package leetcode.problems.linked_list_cycle_ii;

import leetcode.struct.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && slow != null && slow.next != null) {
			fast = fast.next;
			slow = slow.next.next;
			if (fast == slow) {
				while (head != fast) {
					head = head.next;
					fast = fast.next;
				}
				return head;
			}
		}
		return null;
	}
}