package leetcode.problems._201_300.Reverse_Linked_List;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Solution {
	public ListNode reverseListI(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public ListNode reverseList(ListNode head) {
		return recursive(head, null);
	}
	
	public ListNode recursive(ListNode cur, ListNode pre) {
		if (cur == null) {
			return pre;
		}
		ListNode next = cur.next;
		cur.next = pre;
		return recursive(next, cur);
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//Input: head = [1,2,3,4,5]
		//Output: [5,4,3,2,1]
		
		//Example 2:
		//
		//
		//Input: head = [1,2]
		//Output: [2,1]
		
		//Example 3:
		//
		//Input: head = []
		//Output: []
		
		Assertions.assertEquals(ListNode.create(new int[]{5, 4, 3, 2, 1}), reverseList(ListNode.create(new int[]{1, 2, 3, 4, 5})));
		Assertions.assertEquals(ListNode.create(new int[]{2, 1}), reverseList(ListNode.create(new int[]{1, 2})));
		Assertions.assertEquals(ListNode.create(new int[]{}), reverseList(ListNode.create(new int[]{})));
	}
}
