package solution._1_100.Two_Sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			cache.put(target - nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			Integer other = cache.get(num);
			if (other != null && i != other) {
				return new int[]{i, other};
			}
		}
		return null;
	}
}