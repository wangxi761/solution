package struct;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
	}
	
	public String getList() {
		List<Integer> list = new ArrayList<>();
		ListNode head = this;
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list.toString();
	}
	
	@Override
	public String toString() {
		return val + (next == null ? "" : " -> " + next);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListNode listNode = (ListNode) o;
		return val == listNode.val && Objects.equals(next, listNode.next);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(val, next);
	}
	
	public static ListNode create(int... src) {
		if (src.length == 0)
			return null;
		ListNode head = new ListNode(0), node = head;
		for (int i : src) {
			ListNode next = new ListNode(i);
			node.next = next;
			node = next;
		}
		return head.next;
	}
	
}
