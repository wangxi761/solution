package leetcode.problems.happy_number;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean isHappy(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		while (n != 1) {
			if (cache.containsKey(n)) {
				return false;
			}
			int num = n;
			int sum = 0;
			while (num != 0) {
				int digit = num % 10;
				num = num / 10;
				sum += digit * digit;
			}
			cache.put(n, sum);
			n = sum;
		}
		return true;
	}
}