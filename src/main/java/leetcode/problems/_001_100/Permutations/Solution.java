package leetcode.problems._001_100.Permutations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		backtrack(res, nums, nums.length, new ArrayList<>());
		return res;
	}
	
	public void backtrack(List<List<Integer>> res, int[] nums, int len, List<Integer> cur) {
		if (len == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int num : nums) {
			if (cur.contains(num)) {
				continue;
			}
			cur.add(num);
			backtrack(res, nums, len - 1, cur);
			cur.remove(cur.size() - 1);
		}
	}
	
	@Test
	public void test(){
		permute(new int[]{1, 2, 3}).forEach(System.out::println);
	}
}