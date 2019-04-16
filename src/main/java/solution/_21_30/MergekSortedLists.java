package solution._21_30;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import solution.common.ListNode;

@SuppressWarnings("unused")
public class MergekSortedLists {
	/**
	 * 这个好像更慢
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		ListNode mergefirst=new ListNode(0);
		for (ListNode head : lists) {
			while (head != null) {
				queue.add(head.val);
				head = head.next;
			}
		}
		ListNode head = new ListNode(0), first = head;
		for (Integer i : queue) {
			ListNode node = new ListNode(i);
			head.next = node;
			head = node;
		}
		return first.next;
	}

	/**
	 * 这个方法不好-暴力解法
	 */
	public ListNode mergeKListsI(ListNode[] lists) {
		int min = Integer.MAX_VALUE;
		int k = 0;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null && lists[i].val < min) {
				min = lists[i].val;
				k = i;
			}
		}
		if (min == Integer.MAX_VALUE)
			return null;
		lists[k] = lists[k].next;
		ListNode node = new ListNode(min);
		node.next = mergeKLists(lists);
		return node;
	}

	@Test
	public void test() throws Exception {
		ListNode[] lists = { ListNode.create(1, 4, 5), ListNode.create(1, 3, 4), ListNode.create(2, 6) };
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			mergeKLists(lists);
		}
		System.out.println(System.currentTimeMillis() - begin);
		begin = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			mergeKListsI(lists);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

}
