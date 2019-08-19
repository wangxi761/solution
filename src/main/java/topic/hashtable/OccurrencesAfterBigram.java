package topic.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OccurrencesAfterBigram {
	public String[] findOcurrences1(String text, String first, String second) {
		List<String> res = new ArrayList<>();
		String[] split = text.split(" ");
		if (split.length < 3) {
			return null;
		}
		for (int i = 0; i < split.length - 2; i++) {
			if (first.equals(split[i]) && second.equals(split[i + 1])) {
				res.add(split[i + 2]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
	
	public String[] findOcurrences(String text, String first, String second) {
		List<String> res = new ArrayList<>();
		String reg = String.format("(?<=\\b%s %s \\b).+?\\b", first, second);
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		while (m.find()) {
			res.add(m.group());
		}
		return res.toArray(new String[res.size()]);
	}
}