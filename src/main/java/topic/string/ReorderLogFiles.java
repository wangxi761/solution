package topic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {
	
	
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, Comparator.comparing(s -> s.substring(s.indexOf(' ') + 1) + s.substring(0, s.indexOf(' ')), (o1, o2) -> {
			if (Character.isLetter(o1.charAt(0)) && Character.isDigit(o2.charAt(0))) return -1;
			else if (Character.isDigit(o1.charAt(0)) && Character.isLetter(o2.charAt(0))) return 1;
			else if (Character.isDigit(o1.charAt(0)) && Character.isDigit(o2.charAt(0))) return 0;
			else return o1.compareTo(o2);
		}));
		return logs;
	}
}
