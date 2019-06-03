package solution._1_10;

import struct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public void test() {
		int[] a = { 3, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int[] b = { 7 };
		ListNode li=addTwoNumbers(convert(a), convert(b));
		System.out.println(li);
	}

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}

	public int[] twoSum2(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
			} else {
				map.put(numbers[i], i);
			}
		}
		return null;
	}

	public int[] twoSum2I(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return new int[] {};
		}
		int p = 0, q = numbers.length - 1;
		while (p < q) {
			int sum = numbers[p] + numbers[q];
			if (sum < target) {
				p++;
			} else if (sum > target) {
				q--;
			} else {
				return new int[] { p + 1, q + 1 };
			}
		}
		return new int[] {};
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long a = convert(l1), b = convert(l2);
		return convert(a + b);
	}

	public long convert(ListNode li) {
		if (li == null) {
			return 0;
		}
		long k = li.val;
		while (li.next != null) {
			li = li.next;
			k = k * 10 + li.val;
		}
		return k;
	}

	public ListNode convert(long k) {
		String str = String.valueOf(k);
		ListNode li = new ListNode(Integer.parseInt(str.substring(0, 1)));
		ListNode head = li;
		for (int i = 1; i < str.length(); i++) {
			ListNode node = new ListNode(Integer.parseInt(str.substring(i, i + 1)));
			li.next = node;
			li = node;
		}
		return head;
	}
	public ListNode convert(int[] k) {
		if(k.length<1) {
			return null;
		}
		ListNode li=new ListNode(k[0]);
		ListNode head=li;
		for (int i = 1; i < k.length; i++) {
			ListNode node=new ListNode(k[i]);
			li.next=node;
			li=node;
		}
		return head;
	}
}
