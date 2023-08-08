package leetcode.problems._701_800.Design_Linked_List;

import leetcode.struct.ListNode;
import org.junit.jupiter.api.Test;

class MyLinkedList {
	private final ListNode dummy = new ListNode(0);
	private int size = 0;
	
	public MyLinkedList() {
	
	}
	
	public int get(int index) {
		if (index > size - 1 || index < 0) {
			return -1;
		}
		ListNode head = dummy;
		while (index-- >= 0) {
			head = head.next;
		}
		return head.val;
	}
	
	public void addAtHead(int val) {
		ListNode node = new ListNode(val);
		node.next = dummy.next;
		dummy.next = node;
		size++;
	}
	
	public void addAtTail(int val) {
		ListNode head = dummy;
		while (head.next != null) {
			head = head.next;
		}
		head.next = new ListNode(val);
		size++;
	}
	
	public void addAtIndex(int index, int val) {
		if (index > size) return;
		if (index < 0) index = 0;
		ListNode head = dummy;
		while (index-- > 0) {
			head = head.next;
		}
		ListNode node = new ListNode(val);
		node.next = head.next;
		head.next = node;
		size++;
	}
	
	public void deleteAtIndex(int index) {
		if (index >= size || index < 0) return;
		ListNode head = dummy;
		while (index-- > 0) {
			head = head.next;
		}
		if (head == null || head.next == null) return;
		head.next = head.next.next;
		size--;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input
		//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
		//[[], [1], [3], [1, 2], [1], [1], [1]]
		//Output
		//[null, null, null, null, 2, null, 3]
		//
		//Explanation
		//MyLinkedList myLinkedList = new MyLinkedList();
		//myLinkedList.addAtHead(1);
		//myLinkedList.addAtTail(3);
		//myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
		//myLinkedList.get(1);              // return 2
		//myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
		//myLinkedList.get(1);              // return 3
		
		MyLinkedList list=new MyLinkedList();
		list.addAtHead(1);
		list.addAtTail(3);
		list.addAtIndex(1, 2);
		System.out.println(list.get(1));
		list.deleteAtIndex(1);
		System.out.println(list.get(1));
	}
}
