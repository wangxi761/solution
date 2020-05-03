package common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
	@Test
	public void test() {
		String num1 = "12", num2 = "6";
		
		System.out.println(multiply(num1, num2));
	}
	
	public String multiply(String num1, String num2) {
		char[] ch1 = num1.toCharArray();
		char[] ch2 = num2.toCharArray();
		StringBuilder res = new StringBuilder();
		for (int i = ch1.length - 1; i >= 0; i--) {
			int a = 0, c = 0;
			StringBuilder tmp = new StringBuilder();
			for (int j = ch2.length - 1; j >= 0; j--) {
				c = (ch1[i] - '0') * (ch2[j] - '0') + a;
				if (c > 9) {
					a = c / 10;
					c = c % 10;
				}
				tmp.insert(0, c);
			}
			if (a != 0) tmp.insert(0, a);
			res = add(res, tmp);
		}
		return res.toString();
	}
	
	public StringBuilder add(StringBuilder s1, StringBuilder s2) {
		if (s1.length() == 0) {
			return s2;
		}
		s2.append("0");
		StringBuilder res = new StringBuilder();
		int i = s1.length() - 1, j = s2.length() - 1, a = 0;
		while (i >= 0 && j >= 0) {
			int tmp = (s1.charAt(i) - '0') + (s2.charAt(j) - '0') + a;
			a = tmp / 10;
			res.insert(0, tmp % 10);
			i--;
			j--;
		}
		if (i >= 0) {
			for (int idx = i; idx >= 0; idx--) {
				int tmp = (s1.charAt(i) - '0') + a;
				a = tmp / 10;
				res.insert(0, tmp % 10);
			}
		}
		if (j >= 0) {
			for (int idx = j; idx >= 0; idx--) {
				int tmp = (s2.charAt(j) - '0') + a;
				a = tmp / 10;
				res.insert(0, tmp % 10);
			}
		}
		if (a != 0) {
			res.insert(0, a);
		}
		return res;
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
