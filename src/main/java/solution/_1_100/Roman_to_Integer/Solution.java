package solution._1_100.Roman_to_Integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int romanToInt(String s) {
		Map<Character, Integer> romanCache = new HashMap<>();
		romanCache.put('I', 1);
		romanCache.put('V', 5);
		romanCache.put('X', 10);
		romanCache.put('L', 50);
		romanCache.put('C', 100);
		romanCache.put('D', 500);
		romanCache.put('M', 1000);
		
		int sum = 0;
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i == ch.length - 1) {
				sum += romanCache.get(ch[i]);
				continue;
			}
			char cur = ch[i];
			char next = ch[i + 1];
			if (romanCache.get(cur) < romanCache.get(next)) {
				sum += romanCache.get(next) - romanCache.get(cur);
				i++;
			} else {
				sum += romanCache.get(ch[i]);
			}
		}
		return sum;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(3, romanToInt("III"));
		Assertions.assertEquals(58, romanToInt("LVIII"));
		Assertions.assertEquals(1994, romanToInt("MCMXCIV"));
		
	}
}