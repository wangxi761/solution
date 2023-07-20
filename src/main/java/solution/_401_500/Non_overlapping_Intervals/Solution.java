package solution._401_500.Non_overlapping_Intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing(arr -> arr[1]));
		int count = 0;
		int k = Integer.MIN_VALUE;
		for (int i = 0; i < intervals.length; i++) {
			int x = intervals[i][0], y = intervals[i][1];
			if (x >= k) {
				k = y;
			} else {
				count++;
			}
		}
		return count;
	}
	
	@Test
	public void test() {
		//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
		//Output: 1
		//Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
		Assertions.assertEquals(1, eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
		
		//Input: intervals = [[1,2],[1,2],[1,2]]
		//Output: 2
		//Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
		Assertions.assertEquals(2, eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
		
		//Input: intervals = [[1,2],[2,3]]
		//Output: 0
		//Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
		Assertions.assertEquals(0, eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
	}
}