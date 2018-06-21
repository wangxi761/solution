package solution.ten2Twenty;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.common.ListNode;

public class RemoveNthNodeFromEndofList {
	@Test
	public void test() throws Exception {
		ListNode node = ListNode.create(1,2,3);
		ListNode nthFromEnd = removeNthFromEnd(node, 1);
		System.out.println(nthFromEnd.getList());
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first=new ListNode(0),fast=first,slow=first;
		first.next=head;
		for (int i = 0; i < n+1; i++) {
			fast=fast.next;
		}
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
		return first.next;
	}
}
