package solution.zero2Ten;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		String str = String.valueOf(x);
		StringBuffer sb = new StringBuffer(str);
		if (sb.reverse().toString().equals(str)) {
			return true;
		}
		return false;
	}
	public boolean isPalindromeI(int x) {
		if (x < 0)
			return false;
		int result=0;
		for(int i=x;i>0;i/=10) {
			result=result*10+i%10;
		}
		
		return x==result?true:false;
	}
	@Test
	public void test() throws Exception {
		System.out.println(isPalindromeI(123));
	}
}
