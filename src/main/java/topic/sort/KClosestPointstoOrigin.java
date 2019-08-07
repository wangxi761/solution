package topic.sort;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointstoOrigin {
	public int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][2];
		Arrays.sort(points, Comparator.comparing(i -> Math.sqrt(Math.pow(i[0], 2) + Math.pow(i[1], 2))));
		for (int i = 0; i < res.length; i++) {
			res[i][0] = points[i][0];
			res[i][1] = points[i][1];
		}
		return res;
	}
}
