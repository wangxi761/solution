package topic.array;

import java.util.Arrays;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int[][] height = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[i][j] = matrix[i][j] == '1' ? 1 + (i == 0 ? 0 : height[i - 1][j]) : 0;
			}
		}
		System.out.println(Arrays.deepToString(height));
		return 0;
	}
}
