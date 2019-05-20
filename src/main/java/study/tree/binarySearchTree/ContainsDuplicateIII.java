package study.tree.binarySearchTree;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < i + k + 1 && j < nums.length; j++) {
				long tmp = (long) nums[i] - (long) nums[j];
				if (Math.abs(tmp) <= t)
					return true;
			}
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0) {
			return false;
		}
		NavigableSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			Long left = (long) nums[i] - t;
			Long right = (long) nums[i] + t;
			NavigableSet<Long> subSet = set.subSet(left, true, right, true);
			if (!subSet.isEmpty()) {
				return true;
			}
			set.add((long) nums[i]);
			if (i>=k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}
}
