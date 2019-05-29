package topic.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpecialBinaryString {
	public String makeLargestSpecial(String S) {
		int count = 0, k = 0;
		List<String> res = new ArrayList<>();
		
		for (int i = 0; i < S.length(); i++) {
			count += S.charAt(i) == '1' ? 1 : -1;
			if (count == 0) {
				res.add('1' + makeLargestSpecial(S.substring(k + 1, i)) + '0');
				k = i + 1;
			}
		}
		res.sort(Comparator.reverseOrder());
		return String.join("", res);
	}
}
