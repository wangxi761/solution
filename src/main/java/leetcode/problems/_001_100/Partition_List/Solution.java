package leetcode.problems._001_100.Partition_List;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy;
		ListNode curr = head;
		
		while (curr != null && curr.val < x) {
			prev = curr;
			curr = curr.next;
		}
		while (curr != null && curr.next != null) {
			if (curr.next.val < x) {
				ListNode target = curr.next;
				curr.next = curr.next.next;
				
				target.next = prev.next;
				prev.next = target;
				prev = prev.next;
			} else {
				curr = curr.next;
			}
		}
		return dummy.next;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(ListNode.create(1, 0, 2, 2, 4, 3, 5), partition(ListNode.create(1, 4, 3, 0, 2, 5, 2), 3));
		
		//Example 1:
		//
		//Input: head = [1,4,3,2,5,2], x = 3
		//Output: [1,2,2,4,3,5]
		Assertions.assertEquals(ListNode.create(1, 2, 2, 4, 3, 5), partition(ListNode.create(1, 4, 3, 2, 5, 2), 3));
		
		//Example 2:
		//
		//Input: head = [2,1], x = 2
		//Output: [1,2]
		Assertions.assertEquals(ListNode.create(1, 2), partition(ListNode.create(2, 1), 2));
	}
}