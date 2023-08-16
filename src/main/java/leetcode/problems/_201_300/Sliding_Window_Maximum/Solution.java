package leetcode.problems._201_300.Sliding_Window_Maximum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new ArrayDeque<>();
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			if (deque.peekFirst() == i - k) {
				deque.removeFirst();
			}
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		return result;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
		//Output: [3,3,5,5,6,7]
		//Explanation:
		//Window position                Max
		//---------------               -----
		//[1  3  -1] -3  5  3  6  7       3
		// 1 [3  -1  -3] 5  3  6  7       3
		// 1  3 [-1  -3  5] 3  6  7       5
		// 1  3  -1 [-3  5  3] 6  7       5
		// 1  3  -1  -3 [5  3  6] 7       6
		// 1  3  -1  -3  5 [3  6  7]      7
		
		
		//Example 2:
		//
		//Input: nums = [1], k = 1
		//Output: [1]
		
		Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
		Assertions.assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));
	}
}