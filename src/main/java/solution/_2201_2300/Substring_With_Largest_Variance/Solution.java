package solution._2201_2300.Substring_With_Largest_Variance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int largestVariance(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int max = 0;
		for (Character a : map.keySet()) {
			for (Character b : map.keySet()) {
				if (a == b) continue;
				int rA = map.get(a);
				
				int cA = 0, cB = 0;
				for (char c : s.toCharArray()) {
					if (c == b) cB++;
					if (c == a) {
						cA++;
						rA--;
					}
					if (cA > 0) {
						max = Math.max(max, cB - cA);
					}
					if (cB < cA && rA >= 1) {
						cB = 0;
						cA = 0;
					}
				}
			}
		}
		return max;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(3, largestVariance("aababbb"));
		Assertions.assertEquals(0, largestVariance("abcde"));
	}
}