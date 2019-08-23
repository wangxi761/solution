package topic.hashtable;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
	public boolean isHappy(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		while (n != 1) {
			if (cache.containsKey(n)) {
				return false;
			}
			int last = n;
			n = calculation(n);
			cache.put(last, n);
		}
		return true;
	}
	
	public int calculation(int n) {
		int res = 0;
		while (n > 0) {
			res += (n % 10) * (n % 10);
			n /= 10;
		}
		return res;
	}
}
