package study.tree.binarySearchTree;

import java.util.HashMap;
import java.util.Map;

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
		Map<Long, Long> map = new HashMap<>();
		for (int num : nums) {
		}
		return true;
	}
}
