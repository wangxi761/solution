package topic.Backtracking;

import java.util.Arrays;

public class NumberOfSquarefulArrays {
	public int numSquarefulPerms(int[] A) {
		Arrays.sort(A);
		return recursive(A, 0, -1);
	}
	
	private int recursive(int[] a, int n, int last) {
		if (n == a.length) {
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			if (num == -1) continue;
			if (i > 0 && num == a[i - 1]) continue;
			if (last == -1 || isSquare(last, num)) {
				a[i] = -1;
				sum += recursive(a, n + 1, num);
				a[i] = num;
			}
		}
		return sum;
	}
	
	private boolean isSquare(int a, int b) {
		double sqrt = Math.sqrt(a + b);
		return sqrt == Math.floor(sqrt);
	}
}
