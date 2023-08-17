package leetcode.problems._101_200.Linked_List_Cycle_II;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return head;
			}
		}
		return null;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//Input: head = [3,2,0,-4], pos = 1
		//Output: tail connects to node index 1
		//Explanation: There is a cycle in the linked list, where tail connects to the second node.
		ListNode node_3 = new ListNode(3);
		ListNode node_2 = new ListNode(2);
		ListNode node_0 = new ListNode(0);
		ListNode node_4 = new ListNode(-4);
		node_3.next = node_2;
		node_2.next = node_0;
		node_0.next = node_4;
		node_4.next = node_2;
		ListNode actual = detectCycle(node_3);
		Assertions.assertEquals(node_2, actual);
		//Example 2:
		//
		//
		//Input: head = [1,2], pos = 0
		//Output: tail connects to node index 0
		//Explanation: There is a cycle in the linked list, where tail connects to the first node.
		ListNode node_1 = new ListNode(1);
		node_2 = new ListNode(2);
		node_1.next = node_2;
		node_2.next = node_1;
		actual = detectCycle(node_1);
		Assertions.assertEquals(node_1, actual);
		
		//Example 3:
		//
		//
		//Input: head = [1], pos = -1
		//Output: no cycle
		//Explanation: There is no cycle in the linked list.
		node_1 = new ListNode(1);
		actual = detectCycle(node_1);
		Assertions.assertNull(actual);
	}
}