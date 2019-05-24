package topic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> cache = new HashMap<>();
		for (String path : paths) {
			String[] terms = path.split(" ");
			for (int i = 1; i < terms.length; i++) {
				int index = terms[i].indexOf("(");
				String p = terms[0] + "/" + terms[i].substring(0, index);
				String content = terms[i].substring(index + 1, terms[i].length() - 1);
				List<String> list = cache.getOrDefault(content, new ArrayList<>());
				list.add(p);
				cache.put(content, list);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (List<String> value : cache.values()) {
			if (value.size() == 1) continue;
			result.add(value);
		}
		return result;
	}
}
