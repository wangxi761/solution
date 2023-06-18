package solution._2071_2080;

import java.util.HashMap;
import java.util.Map;

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
}
