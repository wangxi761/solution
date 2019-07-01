package topic.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		recursive(res, new ArrayList<>(), nums, visited, 0);
		return res;
	}
	
	public void recursive(List<List<Integer>> res, List<Integer> arr, int[] nums, boolean[] visited, int num) {
		if (num == nums.length) {
			res.add(new ArrayList<>(arr));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) continue;
			if (i > 0 && visited[i] == visited[i - 1] && nums[i] == nums[i - 1]) continue;
			arr.add(nums[i]);
			visited[i] = true;
			recursive(res, arr, nums, visited, num + 1);
			arr.remove(arr.size() - 1);
			visited[i] = false;
		}
		
	}
}
