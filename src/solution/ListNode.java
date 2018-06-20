package solution;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
	
	public static ListNode create(int...src) {
		int[] arr=src;
		if(arr.length==0)
			return null;
		ListNode head=new ListNode(0),node=head;
		for (int i : arr) {
			ListNode next=new ListNode(i);
			node.next=next;
			node=next;
		}
		return head.next;
	}

	
	public String getList() {
		List<Integer> list=new ArrayList<>();
		ListNode head=this;
		while(head!=null) {
			list.add(head.val);
			head=head.next;
		}
		return list.toString();
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
	
	
	
	
}
