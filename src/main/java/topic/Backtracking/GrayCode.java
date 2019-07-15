package topic.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		while (n-- > 0) {
			int size = res.size();
			for (int i = 0; i < size; i++) {
				res.add(res.get(size - i - 1) + size);
			}
		}
		return res;
	}
}
