package topic.array;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1)
				.size()];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < triangle.get(i)
					.size(); j++) {
				Integer cur = triangle.get(i)
						.get(j);
				if (i == 0) {
					dp[i][j] = cur;
				} else if (j == 0) {
					dp[i][j] = cur + dp[i - 1][j];
				} else if (j == triangle.get(i)
						.size() - 1) {
					dp[i][j] = cur + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + cur;
				}
				if (i == dp.length - 1)
					min = Math.min(min, dp[i][j]);
			}
		}
		return min;
	}
}
