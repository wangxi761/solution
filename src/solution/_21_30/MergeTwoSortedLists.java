package solution._21_30;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.common.ListNode;

public class MergeTwoSortedLists {
	@Test
	public void test() throws Exception {
		ListNode l1=ListNode.create(1,2,4);
		ListNode l2=ListNode.create(1,3,4);
		System.out.println(mergeTwoLists(l1, l2).getList());
		
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode first=new ListNode(0),head=first;
		while(l1!=null||l2!=null) {
			if(l1==null) {
				head.next=l2;
				head=l2;
				l2=l2.next;
			}else if(l2==null) {
				head.next=l1;
				head=l1;
				l1=l1.next;
			}else if(l1.val>=l2.val) {
				head.next=l2;
				head=l2;
				l2=l2.next;
			}else {
				head.next=l1;
				head=l1;
				l1=l1.next;
			}
		}
		return first.next;
	}
}
