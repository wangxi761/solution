package topic.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestHarmoniousSubsequence {
	
	public int findLHS(int[] nums) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int num : nums) {
			cache.put(num, cache.getOrDefault(num, 0) + 1);
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
			if (cache.containsKey(entry.getKey() + 1)) {
				max = Math.max(max, entry.getValue() + cache.get(entry.getKey() + 1));
			}
		}
		return max;
	}
	
	public int findLHS1(int[] nums) {
		Map<Integer, Integer> cache = new TreeMap<>();
		for (int num : nums) {
			cache.put(num, cache.getOrDefault(num, 0) + 1);
		}
		if (cache.size() <= 1) {
			return 0;
		}
		int max = 0;
		Map.Entry<Integer, Integer> last = null;
		for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
			if (last == null) {
				last = entry;
				continue;
			}
			if (last.getKey() + 1 == entry.getKey()) {
				max = Math.max(max, entry.getValue() + last.getValue());
			}
			last = entry;
		}
		return max;
	}
	
}
