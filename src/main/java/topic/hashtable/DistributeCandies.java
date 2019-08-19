package topic.hashtable;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {
	public int distributeCandies1(int[] candies) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int candy : candies) {
			map.put(candy, map.getOrDefault(map, 0) + 1);
		}
		return map.size() > candies.length / 2 ? candies.length / 2 : map.size();
	}
	
	public int distributeCandies(int[] candies) {
		int[] cache = new int[100000 * 2 + 1];
		for (int candy : candies) {
			cache[candy + 100000]++;
		}
		int size = 0;
		for (int i : cache) {
			if (i > 0) {
				size++;
			}
		}
		return size > candies.length / 2 ? candies.length / 2 : size;
	}
}
