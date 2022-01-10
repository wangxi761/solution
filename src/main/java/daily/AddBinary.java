package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinary {
	public String addBinary(String a, String b) {
		char[] ach = a.toCharArray();
		char[] bch = b.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = ach.length - 1, j = bch.length - 1;
		int c = 0;
		while (i >= 0 && j >= 0) {
			int l = ach[i] - '0';
			int r = bch[j] - '0';
			int sum = l + r + c;
			if (sum > 1) {
				sum = 0;
				c = 1;
			}
			sb.insert(0,sum);
			i--;
			j--;
		}
		while (i >= 0) {
			int sum = ach[i] - '0' + c;
			if (sum > 1) {
				sum = 0;
				c = 1;
			}
			sb.insert(0,sum);
			i--;
		}
		while (j >= 0) {
			int sum = bch[j] - '0' + c;
			if (sum > 1) {
				sum = 0;
				c = 1;
			}
			sb.insert(0,sum);
			j--;
		}
		if (c != 0) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}
	
	@Test
	public void test() {
		Assertions.assertEquals("100", addBinary("11", "1"));
		Assertions.assertEquals("10101", addBinary("1010", "1011"));
	}
}
