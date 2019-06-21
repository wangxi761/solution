package common;

public class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public static ListNode build(int... val) {
		int[] arr = val;
		if (arr.length == 0) return null;
		ListNode head = new ListNode(arr[0]);
		ListNode first = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			first.next = node;
			first = node;
		}
		return head;
	}
	
	public static ListNode reserve(ListNode head) {
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
		ListNode node = ListNode.build(1, 2, 3, 4, 5);
		ListNode head = ListNode.reserve(node);
	}
}
