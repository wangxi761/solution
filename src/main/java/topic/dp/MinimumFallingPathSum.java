package topic.dp;

import util.ArrayUtil;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] A) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i != 0) {
					int a = A[i - 1][j];
					int b = j + 1 < A.length ? A[i - 1][j + 1] : Integer.MAX_VALUE;
					int c = j > 0 ? A[i - 1][j - 1] : Integer.MAX_VALUE;
					A[i][j] += Math.min(Math.min(a, b), c);
				}
				if (i == A.length - 1) {
					min = Math.min(min, A[i][j]);
				}
			}
		}
		return min;
	}
	
	//错误的解法
	public int minFallingPathSum1(int[][] A) {
		int min = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 1; j < A.length; j++) {
				min = A[i][j] > A[i][min] ? min : j;
			}
			if (i != A.length - 1) {
				A[i + 1][min] += A[i][min];
				if (min + 1 < A.length) A[i + 1][min + 1] += A[i][min];
				if (min > 0) A[i + 1][min - 1] += A[i][min];
			}
		}
		ArrayUtil.prettyPrint(A);
		return A[A.length - 1][min];
	}
}