package solution._21_30;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if(needle.isEmpty())
			return 0;
		char[] needles = needle.toCharArray();
		char[] haystacks = haystack.toCharArray();
		int i=0,j=0,store=i;
		while(i<haystacks.length&&j<needles.length) {
			if(haystacks[i]==needles[j]) {
				i++;j++;
			}else {
				i=store+1;
				store=i;
				j=0;
			}
		}
		if(j==needles.length) {
			return store; 
		}
		return -1;
	}
	@Test
	public void test() throws Exception {
		int strStr = strStr("hello", "ll");
		assertEquals(2, strStr);
	}
}
