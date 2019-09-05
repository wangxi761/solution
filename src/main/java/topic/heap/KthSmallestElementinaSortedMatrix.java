package topic.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (queue.size() < k) {
					queue.offer(matrix[i][j]);
				} else if (queue.peek() > matrix[i][j]) {
					queue.poll();
					queue.offer(matrix[i][j]);
				}
			}
		}
		return queue.poll();
	}
}