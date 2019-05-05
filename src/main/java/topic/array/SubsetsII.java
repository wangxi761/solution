package topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		Arrays.sort(nums);
		int last = nums[0], lsize = 1;
		for (int i = 0; i < nums.length; i++) {
			if (last != nums[i]) {
				last = nums[i];
				lsize = result.size();
			}
			int size = result.size();
			for (int j = size - lsize; j < size; j++) {
				List<Integer> list = new ArrayList<>();
				list.addAll(result.get(j));
				list.add(nums[i]);
				result.add(list);
			}
		}
		return result;
	}


}
