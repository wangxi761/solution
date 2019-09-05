package topic.heap;

public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int max = Integer.MIN_VALUE;
		int count = 0, sum = 0;
		TAG:
		while (sum < 2 * matrix.length - 1) {
			int initCount = count;
			for (int i = 0; i <= sum; i++) {
				int j = sum - i;
				if (i > matrix.length - 1 || j > matrix.length - 1) {
					continue;
				}
				count++;
				if (count == k) {
					count = initCount;
					break TAG;
				}
			}
		}
		for (int i = 0; i <= sum; i++) {
			int j = sum - i;
		}
		return max;
	}
}