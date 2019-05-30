package topic.string;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SmallestRange {
	public int[] smallestRange(List<List<Integer>> nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.get(i)
			                        .size(); j++) {
				map.put(nums.get(i)
				            .get(j), i);
			}
		}
		int i = 0, j = map.size();
		while (i < map.size() && j >= 0 && i < j && map.values()
		                                               .size() == nums.size()) {
			map.remove(i++);
		}
		i--;
		while (i < map.size() && j >= 0 && i < j && map.values()
		                                               .size() == nums.size()) {
			map.remove(j--);
		}
		j++;
		return new int[]{i, j};
	}
}
