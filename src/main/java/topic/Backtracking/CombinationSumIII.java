package topic.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<List<Integer>> results = new ArrayList<>();
		recursive(results, new ArrayList<>(), candidates, k, n);
		return results;
	}
	
	private void recursive(List<List<Integer>> results, List<Integer> result, int[] candidates, int k, int n) {
		if (k > 0 && n > 0) {
			for (int i = 0; i < candidates.length; i++) {
				int num = candidates[i];
				if (num < 0) continue;
				if (result.isEmpty() || num > result.get(result.size() - 1)) {
					result.add(num);
					candidates[i] = -1;
					
					recursive(results, result, candidates, k - 1, n - num);
					
					result.remove(result.size() - 1);
					candidates[i] = num;
				}
			}
		} else if (k == 0 && n == 0) {
			results.add(new ArrayList<>(result));
			return;
		} else {
			return;
		}
	}
}
