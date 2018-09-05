package solution._21_30;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import solution.common.ListNode;

public class ReverseNodesinkGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<Integer> st = new Stack<>();
		ListNode first = new ListNode(0);
		ListNode node = first;
		int i = 1;
		while (head != null) {
			st.push(head.val);
			head = head.next;
			if (i % k == 0) {
				while (!st.isEmpty()) {
					node.next=new ListNode(st.pop());
					node=node.next;
				}
			}
			i++;
		}
		if(!st.isEmpty()) {
			Stack<Integer> sd = new Stack<>();
			while(!st.isEmpty()) {
				sd.push(st.pop());
			}
			while (!sd.isEmpty()) {
				node.next=new ListNode(sd.pop());
				node=node.next;
			}
		}
		return first.next;
	}
}
