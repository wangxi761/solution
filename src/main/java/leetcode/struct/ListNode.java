package leetcode.struct;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
	}
	
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
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
//		return print(new StringBuilder()).toString();
		return print(new ArrayList<>());
	}
	
	private String print(List<ListNode> list) {
		if (list.contains(this)) {
			return list.stream().map(node -> String.valueOf(node.val)).collect(Collectors.joining(" -> "));
		}
		list.add(this);
		if (next == null) {
			return list.stream().map(node -> String.valueOf(node.val)).collect(Collectors.joining(" -> "));
		}
		return next.print(list);
	}
	
	private StringBuilder print(StringBuilder builder) {
		builder.append(val);
		if (next != null) {
			builder.append(" -> ");
			next.print(builder);
		}
		return builder;
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
	
	public static ListNode fromArray(int[] src) {
		return create(src);
	}
	
	static class CodeTest {
		public static void main(String[] args) {
			ListNode node = ListNode.create(1, 2, 3, 4, 5);
			System.out.println(node);
		}
	}
}
