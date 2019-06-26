package topic.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(candidates);
		recursive(results, new ArrayList<>(), candidates, target);
		return results;
	}
	
	public void recursive(List<List<Integer>> results, List<Integer> result, int[] candidates, int target) {
		if (target == 0) {
			results.add(new ArrayList<>(result));
			return;
		} else if (target < 0) {
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			if (result.isEmpty() || candidates[i] >= result.get(result.size() - 1)) {
				result.add(candidates[i]);
				recursive(results, result, candidates, target - candidates[i]);
				result.remove(result.size() - 1);
			}
		}
	}
}
