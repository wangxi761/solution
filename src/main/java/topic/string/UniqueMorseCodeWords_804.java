package topic.string;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UniqueMorseCodeWords_804 {

	public int uniqueMorseRepresentations(String[] words) {
		String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		Set<String> set=new HashSet<>();
		for (String i : words) {
			String str="";
			for (char j : i.toCharArray()) {
				str+=morse[j-'a'];
			}
			set.add(str);
		}
		return set.size();
	}
	@Test
	public void test() throws Exception {
		String[] arr= {"gin", "zen", "gig", "msg"};
		int uniqueMorseRepresentations = uniqueMorseRepresentations(arr);
		assertEquals(2, uniqueMorseRepresentations);
	}
}
