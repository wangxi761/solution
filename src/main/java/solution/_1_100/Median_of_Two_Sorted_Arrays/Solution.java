package solution._1_100.Median_of_Two_Sorted_Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				list.add(nums1[i++]);
			} else {
				list.add(nums2[j++]);
			}
		}
		while (i < nums1.length) {
			list.add(nums1[i++]);
		}
		while (j < nums2.length) {
			list.add(nums2[j++]);
		}
		int size = list.size();
		if (size % 2 == 0) {
			return (list.get(size / 2) + list.get(size / 2 - 1)) / 2d;
		} else {
			return list.get(size / 2);
		}
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(2d, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
		Assertions.assertEquals(2.5d, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
	}
}
