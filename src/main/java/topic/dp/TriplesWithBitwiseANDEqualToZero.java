package topic.dp;

public class TriplesWithBitwiseANDEqualToZero {
	public int countTriplets(int[] A) {
		int[] dp = new int[1 << 16];
		for (int i : A) {
			for (int j : A) {
				++dp[i & j];
			}
		}
		int sum = 0;
		for (int i : A) {
			for (int j = 0; j < dp.length; j++) {
				if ((i & j) == 0) sum += dp[j];
			}
		}
		return sum;
	}
	
	public int countTriplets1(int[] A) {
		return recursive(A, 0, 3);
	}
	
	private int recursive(int[] A, int num, int size) {
		if (size > 0) {
			int sum = 0;
			for (int i = 0; i < A.length; i++) {
				sum += recursive(A, size == 3 ? A[i] : num & A[i], size - 1);
			}
			return sum;
		}
		if (num == 0) {
			return 1;
		}
		return 0;
	}
	
	
}
