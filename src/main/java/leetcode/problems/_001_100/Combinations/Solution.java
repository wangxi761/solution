package leetcode.problems._001_100.Combinations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), 0, n, k);
		return res;
	}
	
	public void backtrack(List<List<Integer>> res, List<Integer> cur, int start, int n, int k) {
		if (k == 0) {
			res.add(cur);
			return;
		}
		for (int i = start; i <= n; i++) {
			cur.add(i);
			backtrack(res, cur, start + 1, n, k - 1);
			cur.remove(cur.size() - 1);
		}
	}
	
	
	@Test
	public void test() {
		combine(4, 2).forEach(System.out::println);
	}
}