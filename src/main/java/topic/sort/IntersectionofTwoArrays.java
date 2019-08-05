package topic.sort;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> sets = new HashSet<>();
		for (int i : nums1) {
			sets.add(i);
		}
		Set<Integer> list = new HashSet<>();
		for (int i : nums2) {
			if (sets.contains(i)) {
				list.add(i);
			}
		}
		int[] ints = new int[list.size()];
		int idx = 0;
		for (Integer i : list) {
			ints[idx++] = i;
		}
		return ints;
	}
}
