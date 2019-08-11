package topic.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
	public int[][] kClosest1(int[][] points, int K) {
		int[][] res = new int[K][2];
		Arrays.sort(points, Comparator.comparing(i -> Math.sqrt(Math.pow(i[0], 2) + Math.pow(i[1], 2))));
		for (int i = 0; i < res.length; i++) {
			res[i] = points[i];
		}
		return res;
	}
	
	public int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][2];
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.<int[]>comparingDouble(i -> length(i)).reversed());
		for (int[] point : points) {
			if (queue.size() < K) {
				queue.offer(point);
			} else if (length(queue.peek()) > length(point)) {
				queue.poll();
				queue.offer(point);
			}
		}
		for (int i = 0; i < res.length; i++) {
			int[] point = queue.poll();
			res[i] = point;
		}
		return res;
	}
	
	public double length(int[] i) {
		return Math.sqrt(Math.pow(i[0], 2) + Math.pow(i[1], 2));
	}
	
	public int help(int[] arr, int begin, int end) {
		int lo = begin, hi = end;
		int pivot = arr[lo];
		while (lo < hi) {
			while (lo < hi && pivot <= arr[hi]) {
				hi--;
			}
			arr[lo] = arr[hi];
			while (lo < hi && pivot >= arr[lo]) {
				lo++;
			}
			arr[hi] = arr[lo];
		}
		arr[lo] = pivot;
		return lo;
	}
}