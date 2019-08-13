package topic.sort;

import java.util.TreeMap;

public class CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {
		TreeMap<Integer, Double> map = new TreeMap<>();
		for (int i = 0; i < speed.length; i++) {
			map.put(-position[i], (target - position[i] + 0.0) / speed[i]);
		}
		double pre = 0;
		int count = 0;
		for (Double value : map.values()) {
			if (value > pre) {
				count++;
				pre = value;
			}
		}
		return count;
	}
}
