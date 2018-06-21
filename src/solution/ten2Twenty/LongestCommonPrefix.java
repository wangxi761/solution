package solution.ten2Twenty;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefix {
	@Test
	public void test() throws Exception {
		assertArrayEquals(new String[] { "fl", "", "" },
				new String[] { longestCommonPrefix(new String[] { "flower", "flow", "flight" }),
						longestCommonPrefix(new String[] { "dog", "racecar", "car" }),
						longestCommonPrefix(new String[] { "ca", "a" }) });
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++) {
			for (int j = pre.length(); j >0; j--) {
				if (!strs[i].startsWith(pre))
					pre = pre.substring(0, j-1);
				if (pre.isEmpty())
					return "";
			}
		}
		return pre;
	}
}
