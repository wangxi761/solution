package topic.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotatedDigits {
	List<Integer> list = Arrays.asList(3, 4, 7);
	List<Integer> list1 = Arrays.asList(2, 5, 6, 9);
	Map<Integer, Boolean> map = new HashMap<>();
	
	public int rotatedDigits(int N) {
		int[] dp = new int[N + 1];
		int count = 0;
		for (int i = 0; i < N + 1; i++) {
			if (i == 3 || i == 7 || i == 4) {
				dp[i] = 0;
			} else if (i == 0 || i == 1 || i == 8) {
				dp[i] = 1;
			} else if (i == 2 || i == 5 || i == 6 || i == 9) {
				dp[i] = 2;
			} else if (dp[i / 10] == 0 || dp[i % 10] == 0) {
				dp[i] = 0;
			} else if (dp[i / 10] + dp[i % 10] > 2) {
				dp[i] = 2;
			} else {
				dp[i] = 1;
			}
			if (dp[i] == 2) count++;
		}
		return count;
	}
	
	
	public int rotatedDigits1(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (isGood(i))
				count++;
		}
		return count;
	}
	
	public boolean isGood(int N) {
		boolean tag = false;
		while (N > 0) {
			int i = N % 10;
			if (list.contains(i)) {
				return false;
			} else if (list1.contains(i)) {
				tag = true;
			}
			N = N / 10;
		}
		return tag;
	}
	
}
