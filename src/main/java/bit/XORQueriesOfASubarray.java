package bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XORQueriesOfASubarray {
	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] xor = new int[arr.length + 1];
		xor[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			xor[i+1] = xor[i] ^ arr[i];
		}
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int begin = queries[i][0];
			int end = queries[i][1];
			res[i] = xor[end+1] ^ xor[begin];
		}
		return res;
	}
	
	@Test
	public void test() {
		assertArrayEquals(new int[]{2, 7, 14, 8}, xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}}));
		assertArrayEquals(new int[]{8, 0, 4, 4}, xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}}));
	}
}
