package solution._2401_2500.Minimum_Cost_to_Make_Array_Equal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public long minCosI(int[] nums, int[] cost) {
		boolean equals = true;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] != nums[i]) {
				equals = false;
				break;
			}
		}
		if (equals) return 0;
		
		long min = Long.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int res = nums[i];
			long sum = 0;
			for (int j = 0; j < nums.length; j++) {
				sum += Math.abs((long) (res - nums[j])) * cost[j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
	
	public long minCost(int[] nums, int[] cost) {
		int res = 0;
		return res;
	}
	
	
	@Test
	public void test() {
		Assertions.assertEquals(8, minCost(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14}));
		Assertions.assertEquals(0, minCost(new int[]{2, 2, 2, 2, 2}, new int[]{4, 2, 8, 1, 3}));
	}
}