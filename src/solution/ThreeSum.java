package solution;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ThreeSum {
	@Test
	public void test() throws Exception {
		List<List<Integer>> threeSum = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		System.out.println(threeSum);
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> list = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int twoSum = 0 - nums[i], lo = 0, hi = nums.length - 1;
			while ((lo < hi)&&(lo!=i)&&(hi!=i)) {
				int sum = nums[lo] + nums[hi];
				if (sum > twoSum)
					hi--;
				else if (sum < twoSum)
					lo++;
				else {
					int[] arr = new int[] { nums[i], nums[lo], nums[hi] };
					List<Integer> li = new ArrayList<>();
					for (int j : arr) {
						li.add(j);
					}
					list.add(li);
					hi--;
					lo++;
				}
			}
		}
		return new ArrayList<>(list);
	}
}
