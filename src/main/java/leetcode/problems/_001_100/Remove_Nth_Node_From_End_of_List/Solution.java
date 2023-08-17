package leetcode.problems._001_100.Remove_Nth_Node_From_End_of_List;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy;
		ListNode curr = head;
		while (n > 0) {
			curr = curr.next;
			n--;
		}
		
		while (curr != null) {
			prev = prev.next;
			curr = curr.next;
		}
		prev.next = prev.next.next;
		
		return dummy.next;
	}
	
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: head = [1,2,3,4,5], n = 2
		//Output: [1,2,3,5]
		
		//Example 2:
		//
		//Input: head = [1], n = 1
		//Output: []
		
		//Example 3:
		//
		//Input: head = [1,2], n = 1
		//Output: [1]
		
		Assertions.assertEquals(ListNode.fromArray(new int[]{1, 2, 3, 5}), removeNthFromEnd(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
		Assertions.assertEquals(ListNode.fromArray(new int[]{}), removeNthFromEnd(ListNode.fromArray(new int[]{1}), 1));
		Assertions.assertEquals(ListNode.fromArray(new int[]{1}), removeNthFromEnd(ListNode.fromArray(new int[]{1, 2}), 1));
	}
}