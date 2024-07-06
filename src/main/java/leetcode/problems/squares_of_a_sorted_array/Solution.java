package leetcode.problems.squares_of_a_sorted_array;

//  Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//
//
//
//  Example 1:
//
//  Input: nums = [-4,-1,0,3,10]
//  Output: [0,1,9,16,100]
//  Explanation: After squaring, the array becomes [16,1,0,9,100].
//      After sorting, it becomes [0,1,9,16,100].
//  Example 2:
//
//  Input: nums = [-7,-3,2,3,11]
//  Output: [4,9,9,49,121]
//
//
//  Constraints:
//
//      1 <= nums.length <= 104
//      -104 <= nums[i] <= 104
//  nums is sorted in non-decreasing order.
//
//
//  Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int[] sortedSquares(int[] nums) {
		int[] squareArray = new int[nums.length];
		int l = 0, r = nums.length - 1, i = nums.length - 1;
		while (l <= r) {
			if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
				squareArray[i] = nums[l] * nums[l];
				l++;
			} else {
				squareArray[i] = nums[r] * nums[r];
				r--;
			}
			i--;
		}
		return squareArray;
	}
	
	@Test
	public void squaresAreSortedInNonDecreasingOrder() {
		int[] nums = {-4, -1, 0, 3, 10};
		int[] expected = {0, 1, 9, 16, 100};
		Assertions.assertArrayEquals(expected, sortedSquares(nums));
	}
	
	@Test
	public void handlesArrayWithNegativeNumbers() {
		int[] nums = {-7, -3, 2, 3, 11};
		int[] expected = {4, 9, 9, 49, 121};
		Assertions.assertArrayEquals(expected, sortedSquares(nums));
	}
	
	@Test
	public void handlesArrayWithSingleElement() {
		int[] nums = {2};
		int[] expected = {4};
		Assertions.assertArrayEquals(expected, sortedSquares(nums));
	}
	
	@Test
	public void handlesArrayWithAllZeroes() {
		int[] nums = {0, 0, 0, 0};
		int[] expected = {0, 0, 0, 0};
		Assertions.assertArrayEquals(expected, sortedSquares(nums));
	}
	
	@Test
	public void handlesArrayWithAllPositiveNumbers() {
		int[] nums = {1, 2, 3, 4};
		int[] expected = {1, 4, 9, 16};
		Assertions.assertArrayEquals(expected, sortedSquares(nums));
	}
	
}