package topic.hashtable;

import java.util.Arrays;
import java.util.Comparator;

public class VerifyinganAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
//		Comparator<String> comparator=(o1, o2) -> {
//			int min = Math.min(o1.length(), o2.length());
//			for (int j = 0; j < min; j++) {
//				char c1 = o1.charAt(j);
//				char c2 = o2.charAt(j);
//				if (c1 != c2) {
//					return order.indexOf(c1) - order.indexOf(c2);
//				}
//			}
//			return o1.length()-o2.length();
//		};
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int min = Math.min(o1.length(), o2.length());
				for (int j = 0; j < min; j++) {
					char c1 = o1.charAt(j);
					char c2 = o2.charAt(j);
					if (c1 != c2) {
						return order.indexOf(c1) - order.indexOf(c2);
					}
				}
				return o1.length() - o2.length();
			}
		};
		if (words.length == 1) return true;
		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1], second = words[i];
			if (comparator.compare(first, second) > 0) {
				return false;
			}
		}
		return true;
	}
}
