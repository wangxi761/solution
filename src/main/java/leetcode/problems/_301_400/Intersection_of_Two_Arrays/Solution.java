package leetcode.problems._301_400.Intersection_of_Two_Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> res = new HashSet<>();
		int[] arr = new int[1001];
		for (int num : nums1) {
			arr[num]++;
		}
		for (int num : nums2) {
			if (arr[num] > 0) {
				res.add(num);
			}
		}
		int[] resInt = new int[res.size()];
		int count = 0;
		for (Integer num : res) {
			resInt[count++] = num;
		}
		return resInt;
	}
	
	//Example 1:
	//
	//Input: nums1 = [1,2,2,1], nums2 = [2,2]
	//Output: [2]
	@Test
	public void test1() {
		Assertions.assertArrayEquals(new int[]{2}, intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
	}
	
	//Example 2:
	//
	//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	//Output: [9,4]
	//Explanation: [4,9] is also accepted.
	@Test
	public void test2() {
		int[] expected = {9, 4};
		int[] intersection = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
		Arrays.sort(expected);
		Arrays.sort(intersection);
		Assertions.assertArrayEquals(expected, intersection);
	}
}