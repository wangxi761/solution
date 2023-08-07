package leetcode.problems._001_100.Search_a_2D_Matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int left = 0, right = m * n - 1;
		
		while (left <= right) {
			int midIndex = left + (right - left) / 2;
			int midValue = matrix[midIndex / n][midIndex % n];
			
			if (midValue < target) {
				left = midIndex + 1;
			} else if (midValue > target) {
				right = midIndex - 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
		//Output: true
		//Example 2:
		//
		//
		//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
		//Output: false
		//
		
		Assertions.assertTrue(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
		Assertions.assertFalse(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
	}
}