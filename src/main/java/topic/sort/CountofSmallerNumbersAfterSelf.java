package topic.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CountofSmallerNumbersAfterSelf {
	public static class Pair<K, V> {
		K k;
		V v;
		
		public Pair(K k, V v) {
			this.k = k;
			this.v = v;
		}
	}
	
	//failure
	public List<Integer> countSmaller2(int[] nums) {
		PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(i -> i.k));
		for (int i = 0; i < nums.length; i++) {
			queue.offer(new Pair<>(nums[i], i));
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			res.add(0);
		}
		int i = 0;
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> pair = queue.poll();
			res.set(pair.v, i++);
		}
		return res;
	}
	
	public List<Integer> countSmaller1(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					count++;
				}
			}
			res.add(count);
		}
		return res;
	}
	
	//failure
	public List<Integer> countSmaller3(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int num = 0;
			for (int j = i; j + 1 < nums.length; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
					num++;
				}
			}
			res.add(0, num);
		}
		return res;
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int data = nums[i];
			int j = i + 1;
			int num = 0;
			while (j < nums.length && nums[j] < data) {
				nums[j - 1] = nums[j];
				j++;
				num++;
			}
			nums[j - 1] = data;
			res.add(0, num);
		}
		return res;
	}
	
	public int lower_bound(int[] nums, int begin, int end, int target) {
		int l = begin, r = end;
		while (l < r) {
			int mid = (r - l) / 2 + l;
			if (mid >= target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}
	
	
	public void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}