package leetcode.problems.swap_nodes_in_pairs;

import leetcode.struct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * static ListNode create(int... src) {}
 * }
 */
class Solution {
	
	
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1, head);
		ListNode cur = dummy;
		
		while (cur.next != null && cur.next.next != null) {
			ListNode first = cur.next;
			ListNode second = cur.next.next;
			
			first.next = second.next;
			second.next = first;
			cur.next = second;
			cur = first;
		}
		return dummy.next;
	}
}