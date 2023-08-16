package leetcode.problems._001_100.Swap_Nodes_in_Pairs;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode curr = dummy;
		while (curr != null && curr.next != null) {
			ListNode first = curr.next;
			ListNode second = curr.next.next;
			
			if (second == null)
				break;
			ListNode third = curr.next.next.next;
			curr.next = second;
			second.next = first;
			first.next = third;
			curr = first;
		}
		return dummy.next;
	}
	
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//Input: head = [1,2,3,4]
		//Output: [2,1,4,3]
		
		//Example 2:
		//
		//Input: head = []
		//Output: []
		
		//Example 3:
		//
		//Input: head = [1]
		//Output: [1]
		
		Assertions.assertEquals(ListNode.create(new int[]{2, 1, 4, 3}), swapPairs(ListNode.create(new int[]{1, 2, 3, 4})));
		Assertions.assertEquals(ListNode.create(new int[]{}), swapPairs(ListNode.create(new int[]{})));
		Assertions.assertEquals(ListNode.create(new int[]{1}), swapPairs(ListNode.create(new int[]{1})));
	}
}
