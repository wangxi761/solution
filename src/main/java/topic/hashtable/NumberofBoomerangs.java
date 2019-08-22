package topic.hashtable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NumberofBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				int len = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
				map.put(len, map.getOrDefault(len, 0) + 1);
			}
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > 1) {
					res += entry.getValue() * (entry.getValue() - 1);
				}
			}
		}
		return res;
	}
	
	public int numberOfBoomerangs1(int[][] points) {
		Arrays.sort(points, Comparator.comparing(i -> i[0] * i[0] + i[1] * i[1]));
		Map<String, Integer> cache = new HashMap<>();
		int[][] candidate = new int[3][2];
		int recursive = recursive(points, candidate, 3, 0, cache);
		return recursive;
	}
	
	public int recursive(int[][] points, int[][] candidate, int size, int index, Map<String, Integer> cache) {
		if (size == 0) {
			int a = calculate(candidate[0], candidate[1], cache);
			int b = calculate(candidate[0], candidate[2], cache);
			int c = calculate(candidate[2], candidate[1], cache);
			if (a == b && b == c) {
				return 6;
			} else if (a == b || b == c || a == c) {
				return 2;
			}
			return 0;
		}
		int res = 0;
		for (int i = index; i < points.length; i++) {
			if (points[i] == null) continue;
			candidate[3 - size] = points[i];
			points[i] = null;
			res += recursive(points, candidate, size - 1, i + 1, cache);
			points[i] = candidate[3 - size];
		}
		return res;
	}
	
	public int calculate(int[] a, int[] b, Map<String, Integer> cache) {
		String key = concat(a, b);
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		int len = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
		cache.put(key, len);
		return len;
	}
	
	
	public String concat(int[] a, int[] b) {
		if (a[0] > b[0]) {
			return "" + a[0] + a[1] + b[0] + b[1];
		} else if (a[0] < b[0]) {
			return "" + b[0] + b[1] + a[0] + a[1];
		} else if (a[1] >= b[1]) {
			return "" + a[0] + a[1] + b[0] + b[1];
		} else {
			return "" + b[0] + b[1] + a[0] + a[1];
		}
	}
}
