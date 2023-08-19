package leetcode.problems._001_100._3Sum;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<List<Integer>> threeSumI(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.computeIfAbsent(nums[i], k -> new HashSet<>()).add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j]) {
					continue;
				}
				int target = -nums[i] - nums[j];
				if (!map.containsKey(target)) {
					continue;
				}
				Set<Integer> set = map.get(target);
				for (Integer k : set) {
					if (k > j) {
						result.add(Arrays.asList(nums[i], nums[j], target));
						break;
					}
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				return result;
			}
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k + 1]) {
						k--;
					}
				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return result;
	}
	
	@Test
	public void test() {
		List<List<Integer>> lists = threeSum(new int[]{-2, 0, 1, 1, 2});
		//Example 1:
		//
		//Input: nums = [-1,0,1,2,-1,-4]
		//Output: [[-1,-1,2],[-1,0,1]]
		//Explanation:
		//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
		//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
		//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
		//The distinct triplets are [-1,0,1] and [-1,-1,2].
		//Notice that the order of the output and the order of the triplets does not matter.
		List<List<Integer>> actual = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
		//assert each list in actual is in expected , list is no order
		Assertions.assertTrue(actual.stream().allMatch(list -> expected.stream().anyMatch(list2 -> Sets.newHashSet(list).equals(Sets.newHashSet(list2)))));
		//Example 2:
		//
		//Input: nums = [0,1,1]
		//Output: []
		//Explanation: The only possible triplet does not sum up to 0.
		Assertions.assertEquals(Collections.emptyList(), threeSum(new int[]{0, 1, 1}));
		
		//Example 3:
		//
		//Input: nums = [0,0,0]
		//Output: [[0,0,0]]
		//Explanation: The only possible triplet sums up to 0.
		Assertions.assertEquals(Collections.singletonList(Arrays.asList(0, 0, 0)), threeSum(new int[]{0, 0, 0}));
		
	}
}