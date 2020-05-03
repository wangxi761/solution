package solution._771_780;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class JewelsandStones {

	public int numJewelsInStonesI(String J, String S) {
		int count=0;
		List<String> list = Arrays.asList(J.split(""));
		for (String i : S.split("")) {
			if(list.contains(i))
				count++;
		}
		return count;
	}
	public int numJewelsInStones(String J, String S) {
		return S.replaceAll("[^"+J+"]", "").length();
	}
	@Test
	public void test() throws Exception {
		String J = "aA", S = "aAAbbbb";
		System.out.println(numJewelsInStones(J, S));
	}
}
