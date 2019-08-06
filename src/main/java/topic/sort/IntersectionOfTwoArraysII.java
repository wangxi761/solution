package topic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			}
		}
		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}
		return res;
	}
	
}
