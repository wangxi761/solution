package solution.ten2Twenty;

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
		List<List<Integer>> threeSum = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println(threeSum);
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> list = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int lo = i+1, hi = nums.length - 1;
			while (lo < hi) {
				int sum=nums[i]+nums[lo]+nums[hi];
				if(sum>0) {
					hi--;
				}else if(sum <0) {
					lo++;
				}else {
					List<Integer> li=new ArrayList<>();
					li.add(nums[i]);li.add(nums[lo]);li.add(nums[hi]);
					list.add(li);
					hi--;lo++;
				}
			}
		}
		return new ArrayList<>(list);
	}
}
