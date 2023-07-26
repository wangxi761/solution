package leetcode.problems._801_900.Peak_Index_in_a_Mountain_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int peakIndexInMountainArray(int[] arr) {
		int l = 0, r = arr.length - 1;
		while (l < r) {
			int i = (l + r) / 2;
			if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
				return i;
			} else if (arr[i - 1] < arr[i] && arr[i] < arr[i + 1]) {
				l = i;
			} else if (arr[i - 1] > arr[i] && arr[i] > arr[i + 1]) {
				r = i;
			}
		}
		return 0;
	}
	
	@Test
	public void test() {
		//Input: arr = [0,1,0]
		//Output: 1
		Assertions.assertEquals(1, peakIndexInMountainArray(new int[]{0, 1, 0}));
		
		//Input: arr = [0,2,1,0]
		//Output: 1
		Assertions.assertEquals(1, peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
		
		//Input: arr = [0,10,5,2]
		//Output: 1
		Assertions.assertEquals(1, peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
	}
}