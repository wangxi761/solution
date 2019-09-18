package common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
	@Test
	public void test() {
		String str = "123a4b5c";
		List<Integer> list = parseInt1(str);
		System.out.println(list);
	}
	
	private List<Integer> parseInt1(String str) {
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c) && sb.length() > 0) {
				list.add(Integer.valueOf(sb.toString()));
				sb.delete(0, sb.length());
			} else if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		return list;
	}
	
	private List<Integer> parseInt(String str) {
		List<Integer> list = new ArrayList<>();
		int l = 0, r = 0;
		while (l < str.length() && r < str.length()) {
			while (l < str.length() && !Character.isDigit(str.charAt(l))) {
				l++;
			}
			r = l;
			while (l < str.length() && Character.isDigit(str.charAt(r))) {
				r++;
			}
			if (l < r) {
				list.add(Integer.valueOf(str.substring(l, r)));
			}
			l = r;
		}
		return list;
	}
}
