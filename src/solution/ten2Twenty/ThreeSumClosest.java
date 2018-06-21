package solution.ten2Twenty;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumClosest {
	@Test
	public void test() throws Exception {
		assertEquals(3, threeSumClosest(new int[] {0,1,2}, 0));
	}

	public int threeSumClosest(int[] nums, int target) {
		int result = Integer.MIN_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int lo = i + 1, hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum > target)
					hi--;
				else
					lo++;
				if(Math.abs(sum-target)<Math.abs(result-target)||result==Integer.MIN_VALUE)
					result=sum;
			}
		}
		return result;
	}
}
