package study.dp.pack;

import static util.ArrayUtil.prettyPrint;

public class CompletePack {
	//由01背包问题直接转换
	public int solution1(int[] w, int[] c, int V) {
		int[] dp = new int[V + 1];
		for (int i = 1; i < w.length + 1; i++) {
			int ci = c[i - 1];
			int wi = w[i - 1];
			for (int j = ci; j < dp.length; j++) {
				if (j < ci) continue;
				dp[j] = Math.max(dp[j], dp[j - ci] + wi);
			}
			prettyPrint(dp);
		}
		return dp[V];
	}
}
