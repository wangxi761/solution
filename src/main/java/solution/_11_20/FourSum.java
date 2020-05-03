package solution._11_20;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FourSum {

	@Test
	public void test() throws Exception {
		int[] arr= {1, 0, -1, 0, -2, 2};
		List<List<Integer>> fourSum = fourSum(arr, 0);
		System.out.println(fourSum);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> list=new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int lo = j + 1, hi = nums.length - 1;
				while(lo<hi) {
					int sum=nums[i]+nums[j]+nums[lo]+nums[hi];
					if(sum>target)
						hi--;
					else if(sum<target)
						lo++;
					else {
						List<Integer> li=new ArrayList<>();
						li.add(nums[i]);
						li.add(nums[j]);
						li.add(nums[lo]);
						li.add(nums[hi]);
						list.add(li);
						lo++;hi--;
					}
				}
			}
		}
		return new ArrayList<>(list);
	}
}
