package topic.string;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> list = new ArrayList<>();
		for (String query : queries) {
			char[] chp = pattern.toCharArray();
			char[] chs = query.toCharArray();
			int i = 0, j = 0;
			while (i < chp.length && j < chs.length) {
				if (chp[i] == chs[j]) {
					i++;
					j++;
				} else if (Character.isUpperCase(chs[j])) {
					list.add(false);
					break;
				} else {
					j++;
				}
			}
			if (i < chp.length && j < chs.length) continue;
			boolean hasUpper = false;
			while (j < chs.length) {
				if (Character.isUpperCase(chs[j++])) {
					hasUpper = true;
					break;
				}
			}
			
			if (i == pattern.length() && !hasUpper) {
				list.add(true);
				continue;
			}
			list.add(false);
		}
		return list;
	}
}
