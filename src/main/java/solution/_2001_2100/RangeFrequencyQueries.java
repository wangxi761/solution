package solution._2001_2100;


import java.util.*;
import java.util.stream.Collectors;

public class RangeFrequencyQueries {
	
	public static class RangeFreqQuery {
		private final Map<String, Integer> cache = new HashMap<>();
		
		private final int[] nums;
		
		public RangeFreqQuery(int[] arr) {
			this.nums = arr;
		}
		
		public int query(int left, int right, int value) {
			String key = left + "," + right + "," + value;
			if (cache.containsKey(key)) return cache.get(key);
			int count = 0;
			for (int i = left; i <= right; i++) {
				if (nums[i] == value) count++;
			}
			cache.put(key, count);
			return count;
		}
	}
	
	public static class RangeFreqQueryI {
		private final Map<Integer, List<Integer>> map = new HashMap<>();
		
		public RangeFreqQueryI(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
				list.add(i);
				map.put(arr[i], list);
			}
		}
		
		public int query(int left, int right, int value) {
			List<Integer> its = map.get(value);
			if (its == null) return 0;
			int i = Collections.binarySearch(its, left);
			int j = Collections.binarySearch(its, right);
			if (i < 0) i = -i - 1;
			if (j < 0) j = -j - 2;
			return j - i + 1;
		}
	}
	
	
	static class CodeTest {
		public static void main(String[] args) {
			int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
			TreeMap<Integer, List<Integer>> map = new TreeMap<>();
			for (int i = 0; i < arr.length; i++) {
				List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
				list.add(i);
				map.put(arr[i], list);
			}
			map.forEach((k, v) -> System.out.println(k + " -> " + v));
			List<Integer> its = map.get(4);
			int i = Collections.binarySearch(its, 1);
			int j = Collections.binarySearch(its, 5);
			System.out.println(i + " " + j);
		}
	}
}
