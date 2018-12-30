package contest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NumbersWithSameConsecutiveDifferences_967 {
	public int[] numsSameConsecDiff(int N, int K) {
		int count = 9 - K;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= count; i++) {
			int j = K + i;
			add(list, combina(i, j, N));
			add(list, combina(j, i, N));
		}
		int[] d = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			d[i] = list.get(i);
		}
		return d;
	}

	public void add(List<Integer> list, int num) {
		if(num<0)
			return;
		if(!list.contains(num))
			list.add(num);
	}

	public int combina(int a, int b, int N) {
		int result = 0;
		if (N == 1)
			return a;
		else if (a == 0)
			return Integer.MIN_VALUE;
		for (int i = 0; i < N / 2; i++) {
			result = result * 10 + a;
			result = result * 10 + b;
		}
		if (N % 2 == 1)
			result = result * 10 + a;
		return result;
	}

	@Test
	public void test() throws Exception {
		int[] numsSameConsecDiff = numsSameConsecDiff(1, 6);
		System.out.println(Arrays.toString(numsSameConsecDiff));
	}
}
