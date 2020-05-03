package common;

import org.junit.jupiter.api.Test;
import struct.ListNode;

public class JsonTest {
	@Test
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode head = reserve(node1);
		System.out.println(head.getList());
	}
	
	public ListNode reserve(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode next = head.next;
			ListNode last = next.next;
			next.next = head;
			head.next = reserve(last);
			return next;
		}
	}
	
	public static void main(String[] args) {
	
	}
	
}
