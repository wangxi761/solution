package solution.zero2Ten;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode li = new ListNode(0);
		ListNode head=li;
		int sum=0,carry=0;
		while (l1!=null || l2!=null) {
			int a=l1==null?0:l1.val;
			int b=l2==null?0:l2.val;
			sum=a+b+carry;
			li.next=new ListNode(sum%10);
			li=li.next;
			carry=sum/10;
			l1=l1==null?null:l1.next;
			l2=l2==null?null:l2.next;
		}
		if(carry!=0) {
			li.next=new ListNode(carry);
		}
		return head.next;
	}

}
