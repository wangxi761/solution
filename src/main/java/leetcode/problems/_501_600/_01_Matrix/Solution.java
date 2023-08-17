package leetcode.problems._501_600._01_Matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length, n = mat[0].length, max = m + n;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					continue;
				}
				int left = max, top = max;
				if (i - 1 >= 0) {
					top = mat[i - 1][j];
				}
				if (j - 1 >= 0) {
					left = mat[i][j - 1];
				}
				mat[i][j] = Math.min(left, top) + 1;
			}
		}
		
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (mat[i][j] == 0) {
					continue;
				}
				int right = max, down = max;
				if (i + 1 < m) {
					down = mat[i + 1][j];
				}
				if (j + 1 < n) {
					right = mat[i][j + 1];
				}
				mat[i][j] = Math.min(Math.min(right, down) + 1, mat[i][j]);
			}
		}
		return mat;
	}
	
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
		//Output: [[0,0,0],[0,1,0],[0,0,0]]
		
		//Example 2:
		//
		//
		//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
		//Output: [[0,0,0],[0,1,0],[1,2,1]]
		
		Assertions.assertArrayEquals(new int[][]{{0}, {1}}, updateMatrix(new int[][]{{0}, {1}}));
		Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
		Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
	}
}