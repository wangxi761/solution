package topic.heap;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int count = 0;
		for (int t = 0; t < matrix.length * 2 - 1; t++) {
			List<Integer> list = new ArrayList<>();
			boolean tag = false;
			for (int i = 0; i <= t; i++) {
				int j = t - i;
				if (i > matrix.length - 1 || j > matrix.length - 1) continue;
				count++;
				list.add(matrix[i][j]);
				if (count == k) {
					tag = true;
				}
			}
			if (tag) {
			
			}
		}
		return 0;
	}
}