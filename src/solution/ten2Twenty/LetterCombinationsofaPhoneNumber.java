package solution.ten2Twenty;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LetterCombinationsofaPhoneNumber {
	@Test
	public void test() throws Exception {
		assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		Map<Integer, List<String>> map = new HashMap<>();
		map.put(2, Arrays.asList("a", "b", "c"));
		map.put(3, Arrays.asList("d", "e", "f"));
		map.put(4, Arrays.asList("g", "h", "i"));
		map.put(5, Arrays.asList("j", "k", "l"));
		map.put(6, Arrays.asList("m", "n", "o"));
		map.put(7, Arrays.asList("p", "q", "r", "s"));
		map.put(8, Arrays.asList("t", "u", "v"));
		map.put(9, Arrays.asList("w", "x", "y", "z"));

		char[] charArray = digits.toCharArray();
		List<String> li = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			int numericValue = Character.getNumericValue(c);
			List<String> list = map.get(numericValue);
			if (li.size()==0) {
				li = list;
			} else {
				List<String> nlist = new ArrayList<>();
				for (String j : li) {
					for (String k : list) {
						nlist.add(j + k);
					}
				}
				li = nlist;
			}
		}
		return li;
	}
}
