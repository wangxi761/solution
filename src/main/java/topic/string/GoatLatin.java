package topic.string;

import java.util.Arrays;
import java.util.List;

public class GoatLatin {
	public String toGoatLatin(String S) {
		List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		String[] ss = S.split(" ");
		for (int i = 0; i < ss.length; i++) {
			if (!list.contains(ss[i].charAt(0))) {
				ss[i] = ss[i].length() == 1 ? ss[i] : ss[i].substring(1) + ss[i].charAt(0);
			}
			ss[i] += "ma";
			for (int j = 0; j < i + 1; j++) {
				ss[i] += "a";
			}
		}
		return String.join(" ", ss);
	}
}
