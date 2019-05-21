package topic.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		List<String> numbers = new ArrayList<>();
		List<String> letter = new ArrayList<>();

		for (String i : logs) {
			String[] strs = i.split(" ");
			if (Character.isDigit(strs[1].charAt(0))) {
				numbers.add(i);
			} else {
				letter.add(i);
			}
		}
		letter.sort(Comparator.comparing(i -> i.substring(i.indexOf(" ") + 1)));
		letter.addAll(numbers);
		Comparator<String> c=Comparator.comparing(i -> i.substring(i.indexOf(" ") + 1))	;
		return letter.toArray(new String[letter.size()]);
	}
}
//Comparator.comparing(i -> i.substring(i.indexOf(" ") + 1))
//.thenComparing(i -> i.split(" ")[0])