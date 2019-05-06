package topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows==0)
			return result;
		result.add(Arrays.asList(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			List<Integer> last = result.get(i - 1);
			for (int j = 0; j <= last.size(); j++) {
				if (j - 1 < 0 || j == last.size())
					list.add(1);
				else
					list.add(last.get(j - 1) + last.get(j));
			}
			result.add(list);
		}
		return result;
	}
}
