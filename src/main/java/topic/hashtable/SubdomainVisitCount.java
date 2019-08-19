package topic.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
	public List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String cpdomain : cpdomains) {
			int blankIdx = cpdomain.indexOf(" ");
			int count = Integer.parseInt(cpdomain.substring(0, blankIdx));
			String domain = cpdomain.substring(blankIdx + 1, cpdomain.length());
			while (domain.contains(".")) {
				Integer origin = map.getOrDefault(domain, 0);
				map.put(domain, origin + count);
				domain = domain.substring(domain.indexOf(".") + 1, domain.length());
			}
			Integer origin = map.getOrDefault(domain, 0);
			map.put(domain, origin + count);
		}
		List<String> res = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			res.add(entry.getValue() + " " + entry.getKey());
		}
		return res;
	}
}
