package topic.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		recursive(0, 0, 0, num, res);
		return res;
	}
	
	public void recursive(int hour, int minute, int i, int count, List<String> res) {
		if (count == 0) {
			if (hour < 12 && minute < 60)
				res.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
			return;
		}
		if (i == 10) {
			return;
		}
		for (int j = i; j < 10; j++) {
			if (j < 4) {
				recursive(hour + (int) Math.pow(2, j), minute, j + 1, count - 1, res);
			} else {
				recursive(hour, minute + (int) Math.pow(2, j - 4), j + 1, count - 1, res);
			}
		}
	}
	
}
