package solution.zero2Ten;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromicSubstring {
	
	
	@Test
	public void test() throws Exception {
		System.out.println(longestPalindrome("abcda"));
	}
	
	public String longestPalindrome(String s) {
		char[] str=s.toCharArray();
		if(str.length==1||str.length==0)
			return s;
		String longest="";
		for (int i = 0; i < str.length; i++) {
			//奇数
			int left=i-1,right=i+1;
			while(left>=0&&right<str.length&&str[left]==str[right]) {
				int len=right-left+1;
				if(len>longest.length()) {
					longest=s.substring(left,right+1);
				}
				left--;right++;
			}
			//偶数
			left=i;right=i+1;
			while(left>=0&&right<str.length&&str[left]==str[right]) {
				int len=right-left+1;
				if(len>longest.length()) {
					longest=s.substring(left,right+1);
				}
				left--;right++;
			}
		}
		if(longest.isEmpty()) {
			longest=s.substring(0,1);
		}
		return longest;
	}
}
