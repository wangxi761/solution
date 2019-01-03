package contest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class NumbersWithSameConsecutiveDifferences_967 {

	public int[] numsSameConsecDiff(int N, int K) {
		List<Integer> list = new ArrayList<>();
		int begin = N == 1 ? 0 : 1;
		for (int i = begin; i < 10; i++) {
			dfs(N, K, i, i, 0, list);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	public void dfs(int N, int K, int now, int pre, int index, List<Integer> list) {
		if (index == N - 1) {
			list.add(now);
			return;
		}
		int x1 = K + pre;
		if (x1 < 10)
			dfs(N, K, x1 + now * 10, x1, index + 1, list);
		int x2 = pre - K;
		if (x2 != x1 && x2 >= 0)
			dfs(N, K, x2 + now * 10, x2, index + 1, list);
	}

	@Test
	public void test() throws Exception {
		int[] numsSameConsecDiff = numsSameConsecDiff(3, 7);
		System.out.println(Arrays.toString(numsSameConsecDiff));
	}
}
