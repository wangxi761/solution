package topic.array;

public class UniquePaths {
	public int uniquePaths1(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		else
			return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}
	public int uniquePaths2(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	public int uniquePaths3(int m, int n) {
    	int pre[]=new int[n],cur[]=new int[n];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if(i==0||j==0) {
    				cur[j]=1;
    				pre[j]=1;
    			}
    			else
    				cur[j]=pre[j]+cur[j-1]; 	
			}
			int[] tmp=pre;
			pre=cur;
			cur=pre;
		}
    	return pre[n-1];
    }
	public int uniquePaths(int m, int n) {
		int[] dp=new int[n];
		for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if(i==0||j==0) 
    				dp[j]=1;
    			else
    				dp[j]+=dp[j-1];
    		}
		}
		return dp[n-1];
	}

}
