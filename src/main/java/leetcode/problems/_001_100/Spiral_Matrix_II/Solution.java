package leetcode.problems._001_100.Spiral_Matrix_II;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
	public int[][] generateMatrix(int n) {
		int count = 1;
		int[][] matrix = new int[n][n];
		int x = 0, y = 0;
		int offset = 1;
		while (offset <= n / 2) {
			while (y < n - offset) {
				matrix[x][y++] = count++;
			}
			while (x < n - offset) {
				matrix[x++][y] = count++;
			}
			while (y >= offset) {
				matrix[x][y--] = count++;
			}
			while (x >= offset) {
				matrix[x--][y] = count++;
			}
			offset++;
			x++;
			y++;
		}
		if (n % 2 == 1) {
			matrix[n / 2][n / 2] = count;
		}
		return matrix;
	}
	
	@Test
	public void test() {
		for (int[] it : generateMatrix(5)) {
			System.out.println(Arrays.toString(it));
		}
	}
}