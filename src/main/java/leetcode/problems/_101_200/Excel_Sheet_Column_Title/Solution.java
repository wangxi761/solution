package leetcode.problems._101_200.Excel_Sheet_Column_Title;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();
		while (columnNumber > 0) {
			columnNumber--;
			sb.append((char) ('A' + (columnNumber % 26)));
			columnNumber = columnNumber / 26;
		}
		return sb.reverse().toString();
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: columnNumber = 1
		//Output: "A"
		//Example 2:
		//
		//Input: columnNumber = 28
		//Output: "AB"
		//Example 3:
		//
		//Input: columnNumber = 701
		//Output: "ZY"
		Assertions.assertEquals("A", convertToTitle(1));
		Assertions.assertEquals("AB", convertToTitle(28));
		Assertions.assertEquals("ZY", convertToTitle(701));
	}
}

