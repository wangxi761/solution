package solution;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		int min = Integer.MAX_VALUE;
		int k=0;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i]!=null&&lists[i].val < min) {
				min = lists[i].val;
				i=k;
			}
		}
		if(min==Integer.MAX_VALUE)
			return null;
		if (lists[k].next == null) {
			lists[k] = null;
		} else {
			lists[k].val = lists[k].next.val;
			lists[k].next = lists[k].next.next;
		}
		ListNode node=new ListNode(min);
		System.out.print(min);
		node.next=mergeKLists(lists);
		return node;
	}

	@Test
	public void test() throws Exception {
		ListNode[] lists= {
				ListNode.create(1,4,5),
				ListNode.create(1,3,4),
				ListNode.create(2,6)
		};
		ListNode mergeKLists = mergeKLists(lists);
		System.out.println(mergeKLists.getList());
	}

}
