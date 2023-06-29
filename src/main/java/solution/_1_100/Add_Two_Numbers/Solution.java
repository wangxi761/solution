package solution._1_100.Add_Two_Numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.ListNode;

class Solution {
	public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			if (sum >= 10) {
				sum -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(sum);
			node = node.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int sum = l1.val + carry;
			if (sum >= 10) {
				sum -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(sum);
			node = node.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int sum = l2.val + carry;
			if (sum >= 10) {
				sum -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(sum);
			node = node.next;
			l2 = l2.next;
		}
		if (carry != 0) {
			node.next = new ListNode(carry);
		}
		
		return head.next;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (l1 != null || l2 != null) {
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			carry = sum / 10;
			sum = sum % 10;
			node.next = new ListNode(sum);
			node = node.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		if (carry != 0) {
			node.next = new ListNode(carry);
		}
		
		return head.next;
	}
	
	
	@Test
	public void test() {
		Assertions.assertEquals(ListNode.create(7, 0, 8), addTwoNumbers(ListNode.create(2, 4, 3), ListNode.create(5, 6, 4)));
		Assertions.assertEquals(ListNode.create(0), addTwoNumbers(ListNode.create(0), ListNode.create(0)));
		Assertions.assertEquals(ListNode.create(8, 9, 9, 9, 0, 0, 0, 1), addTwoNumbers(ListNode.create(9, 9, 9, 9, 9, 9, 9), ListNode.create(9, 9, 9, 9)));
	}
}
