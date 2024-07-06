package leetcode.problems.spiral_matrix_ii;

//      Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
//
//
//      Example 1:
//
//
//      Input: n = 3
//      Output: [[1,2,3],[8,9,4],[7,6,5]]
//      Example 2:
//
//      Input: n = 1
//      Output: [[1]]


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int[][] generateMatrix(int n) {
		int[][] mx = new int[n][n];
		int num = 1;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				mx[i][j] = num++;
			}
			for (int j = i; j < n - 1 - i; j++) {
				mx[j][n - i - 1] = num++;
			}
			for (int j = i; j < n - 1 - i; j++) {
				mx[n - i - 1][n - j - 1] = num++;
			}
			for (int j = i; j < n - 1 - i; j++) {
				mx[n - j - 1][i] = num++;
			}
		}
		if (n % 2 == 1) {
			mx[n / 2][n / 2] = num++;
		}
		return mx;
	}
	
	@Test
	public void generates3x3SpiralMatrix() {
		int n = 3;
		int[][] expected = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
		Assertions.assertArrayEquals(expected, generateMatrix(n));
	}
	
	@Test
	public void generates1x1SpiralMatrix() {
		int n = 1;
		int[][] expected = {{1}};
		Assertions.assertArrayEquals(expected, generateMatrix(n));
	}
	
	@Test
	public void generates2x2SpiralMatrix() {
		int n = 2;
		int[][] expected = {{1, 2}, {4, 3}};
		Assertions.assertArrayEquals(expected, generateMatrix(n));
	}
	
	@Test
	public void generates4x4SpiralMatrix() {
		int n = 4;
		int[][] expected = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
		Assertions.assertArrayEquals(expected, generateMatrix(n));
	}
	
	@Test
	public void generates5x5SpiralMatrix() {
		int n = 5;
		int[][] expected = {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};
		Assertions.assertArrayEquals(expected, generateMatrix(n));
	}
	
}