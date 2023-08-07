package leetcode.problems._201_300.Remove_Linked_List_Elements;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0, head);
		ListNode node = dummy;
		while (node.next != null) {
			if (node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return dummy.next;
	}
	
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//Input: head = [1,2,6,3,4,5,6], val = 6
		//Output: [1,2,3,4,5]
		//Example 2:
		//
		//Input: head = [], val = 1
		//Output: []
		//Example 3:
		//
		//Input: head = [7,7,7,7], val = 7
		//Output: []
		Assertions.assertEquals(ListNode.create(1, 2, 3, 4, 5), removeElements(ListNode.create(1, 2, 6, 3, 4, 5, 6), 6));
		Assertions.assertEquals(ListNode.create(), removeElements(ListNode.create(), 1));
		Assertions.assertEquals(ListNode.create(), removeElements(ListNode.create(7, 7, 7, 7), 7));
	}
}