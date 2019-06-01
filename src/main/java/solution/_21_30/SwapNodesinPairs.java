package solution._21_30;

import struct.ListNode;

public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode node=head.next;
		head.next=swapPairs(head.next.next);
		node.next=head;
		return node;
	}
	public ListNode swapPairsI(ListNode head) {
		while(head==null||head.next==null) {
			
		}
		return head;
	}
}
