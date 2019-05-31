package study.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows > 0) {
			recursive(result, numRows);
		}
		return result;
	}
	
	
	private void recursive(List<List<Integer>> result, int i) {
		if (i == 1) {
			result.add(Arrays.asList(1));
			return;
		}
		recursive(result, i - 1);
		List<Integer> pre = result.get(result.size() - 1);
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			if (j == 0) {
				list.add(1);
			} else if (j == i - 1) {
				list.add(1);
			} else {
				list.add(pre.get(j) + pre.get(j - 1));
			}
		}
		result.add(list);
	}
}
