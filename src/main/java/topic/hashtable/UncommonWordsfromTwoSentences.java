package topic.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsfromTwoSentences {
	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : (A + " " + B).split(" ")) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		List<String> res = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				res.add(entry.getKey());
			}
		}
		return res.toArray(new String[res.size()]);
	}
	
}
