package topic.string;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

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
