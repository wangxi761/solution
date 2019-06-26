package topic.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		int[] candidates = new int[n];
		for (int i = 0; i < n; i++) {
			candidates[i] = i + 1;
		}
		List<List<Integer>> results = new ArrayList<>();
		recursive(results, new ArrayList<>(), candidates, k);
		return results;
	}
	
	private void recursive(List<List<Integer>> results, List<Integer> result, int[] candidates, int k) {
		if (k == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			int num = candidates[i];
			if (num < 0) {
				continue;
			}
			if (result.isEmpty() || result.get(result.size() - 1) < num) {
				result.add(num);
				candidates[i] = -1;
				recursive(results, result, candidates, k - 1);
				candidates[i] = num;
				result.remove(result.size() - 1);
			}
		}
	}
}
