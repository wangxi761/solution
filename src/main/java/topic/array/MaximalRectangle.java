package topic.array;

import java.util.Arrays;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int[][] height = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[i][j] = matrix[i][j] == '1' ? 1 + (i == 0 ? 0 : height[i - 1][j]) : 0;
			}
			int[] heights=height[i];
			for (int index = 0; index < heights.length; index++) {
				int min = heights[index];
				for (int j = index; j < heights.length; j++) {
					min = Math.min(heights[j], min);
					max = Math.max(max, min * (j - index + 1));
				}
			}
		}
		return max;
	}
}
