package topic.array;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (j > 0)
                        dp[j] += dp[j - 1];
                } else
                    dp[j] = 0;
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

}
