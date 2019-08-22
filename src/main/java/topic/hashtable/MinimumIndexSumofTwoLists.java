package topic.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			m1.put(list1[i], i);
		}
		int min = Integer.MAX_VALUE;
		List<String> res = new ArrayList<>();
		for (int i = 0; i < list2.length; i++) {
			if (m1.containsKey(list2[i])) {
				if (min < i + m1.get(list2[i])) {
					continue;
				} else if (min == i + m1.get(list2[i])) {
					res.add(list2[i]);
				} else {
					res.clear();
					res.add(list2[i]);
					min = i + m1.get(list2[i]);
				}
			}
		}
		return res.toArray(new String[res.size()]);
	}
}
