package topic.heap;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>(), tail = new HashMap<>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		for (int num : nums) {
			if (count.get(num) == 0) continue;
			if (tail.containsKey(num) && tail.get(num) > 0) {
				tail.put(num, tail.get(num) - 1);
				tail.put(num + 1, tail.getOrDefault(num + 1, 0) + 1);
			} else if (count.containsKey(num + 1) && count.containsKey(num + 2) && count.get(num + 1) > 0 && count.get(num + 2) > 0) {
				count.put(num + 1, count.get(num + 1) - 1);
				count.put(num + 2, count.get(num + 2) - 1);
				tail.put(num + 3, tail.getOrDefault(num + 3, 0) + 1);
			} else {
				return false;
			}
			count.put(num, count.get(num) - 1);
		}
		return true;
	}
}
