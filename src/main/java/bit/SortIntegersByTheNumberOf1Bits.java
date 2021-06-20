package bit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SortIntegersByTheNumberOf1Bits {
	public int[] sortByBits(int[] arr) {
		int[] res = new int[arr.length];
		Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>(Comparator.naturalOrder());
		for (int i : arr) {
			int count = Integer.bitCount(i);
			PriorityQueue<Integer> queue = map.computeIfAbsent(count, it -> new PriorityQueue<>(Comparator.naturalOrder()));
			queue.offer(i);
		}
		int i = 0;
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			PriorityQueue<Integer> value = entry.getValue();
			while (!value.isEmpty()) {
				res[i++] = value.poll();
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		assertArrayEquals(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}, sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
		assertArrayEquals(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}, sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
		assertArrayEquals(new int[]{10000, 10000}, sortByBits(new int[]{10000, 10000}));
		assertArrayEquals(new int[]{2, 3, 5, 17, 7, 11, 13, 19}, sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19}));
		assertArrayEquals(new int[]{10, 100, 10000, 1000}, sortByBits(new int[]{10, 100, 1000, 10000}));
	}
	
}