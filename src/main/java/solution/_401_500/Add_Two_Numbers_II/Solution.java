package solution._401_500.Add_Two_Numbers_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.ListNode;

import java.util.Stack;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		
		ListNode head = null;
		int carry = 0;
		while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
			int sum = carry;
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}
			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;
			node.next = head;
			head = node;
		}
		return head;
	}
	
	
	@Test
	public void test() {
		//Input: l1 = [7,2,4,3], l2 = [5,6,4]
		//Output: [7,8,0,7]
		Assertions.assertEquals(ListNode.create(7, 8, 0, 7), addTwoNumbers(ListNode.create(7, 2, 4, 3), ListNode.create(5, 6, 4)));
		//Input: l1 = [2,4,3], l2 = [5,6,4]
		//Output: [8,0,7]
		Assertions.assertEquals(ListNode.create(8, 0, 7), addTwoNumbers(ListNode.create(2, 4, 3), ListNode.create(5, 6, 4)));
		//Input: l1 = [0], l2 = [0]
		//Output: [0]
		Assertions.assertEquals(ListNode.create(0), addTwoNumbers(ListNode.create(0), ListNode.create(0)));
	}
}
