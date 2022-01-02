package daily;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairsofSongsWithTotalDurationsDivisibleby60 {
	
	
	public int numPairsDivisibleBy60(int[] time) {
		return second(time);
	}
	
	//Time Limit Exceeded
	public int first(int[] time) {
		int sum = 0;
		for (int i = 0; i < time.length; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if ((time[i] + time[j]) % 60 == 0) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	/**
	 * 30 2
	 * 20 1
	 * 40 2
	 *
	 * @param time
	 *
	 * @return
	 */
	public int second(int[] time) {
		int sum = 0;
		Map<Integer, Integer> cache = new HashMap<>();
		Set<Integer> used = new HashSet<>();
		for (int item : time) {
			int remainder = item % 60;
			Integer count = cache.getOrDefault(remainder, 0);
			cache.put(remainder, count + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
			if (used.contains(entry.getKey()) || entry.getKey().equals(30)) {
				continue;
			}
			Integer other = cache.getOrDefault(60 - entry.getKey(), 0);
			sum += entry.getValue() * other;
			used.add(60 - entry.getKey());
			used.add(entry.getKey());
		}
		if (cache.getOrDefault(30, 0) > 1) {
			sum += choose(cache.get(30), 2);
		}
		if (cache.getOrDefault(0, 0) > 1) {
			sum += choose(cache.get(0), 2);
		}
		return sum;
	}
	
	public int choose(long total, long choose) {
		if (total < choose)
			return 0;
		if (choose == 0 || choose == total)
			return 1;
		return choose(total - 1, choose - 1) + choose(total - 1, choose);
	}
	
	public int third(int[] time) {
		int[] cache = new int[60];
		int res = 0;
		for (int t : time) {
			res += cache[(600 - t) % 60];
			cache[t % 60] += 1;
		}
		return res;
	}
	
	@Test
	public void test() {
		assert second(new int[]{60, 60, 60}) == 3;
		assert second(new int[]{30, 20, 150, 100, 40}) == 3;
	}
}
