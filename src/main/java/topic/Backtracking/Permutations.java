package topic.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		recursive(result, new ArrayList<>(), nums);
		return result;
	}
	
	public void recursive(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i])) continue;
				tempList.add(nums[i]);
				recursive(result, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
