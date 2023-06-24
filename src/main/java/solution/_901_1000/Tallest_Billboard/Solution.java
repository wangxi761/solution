package solution._901_1000.Tallest_Billboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int tallestBillboard(int[] rods) {
		Map<Integer, Integer> dp = new HashMap<>();
		dp.put(0, 0);
		
		for (int rod : rods) {
			Map<Integer, Integer> ndp = new HashMap<>(dp);
			for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
				int diff = entry.getKey();
				int taller = entry.getValue();
				int shorter = taller - diff;
				
				int nTaller = ndp.getOrDefault(diff + rod, 0);
				ndp.put(diff + rod, Math.max(nTaller, taller + rod));
				
				int nDiff = Math.abs(shorter + rod - taller);
				int nTaller2 = Math.max(shorter + rod, taller);
				ndp.put(nDiff, Math.max(nTaller2, ndp.getOrDefault(nDiff, 0)));
			}
			dp = ndp;
		}
		return dp.getOrDefault(0, 0);
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(6, tallestBillboard(new int[]{1, 2, 3, 6}));
	}
}