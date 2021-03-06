/**
 * 
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
 */
package solution._1_10;


import org.junit.jupiter.api.Test;

/**
 * @author wx224
 *
 */
public class StringtoInteger {
	
	public int myAtoi(String str) {
		int i=0,result=0,sign=1;
		char[] strs=str.toCharArray();
		
		
		if(str.length()==0) return 0;//空字符串
		
		while(i<strs.length&&strs[i]==' ')
			i++;
		if(i<strs.length) {
			if(strs[i]=='+'||strs[i]=='-')
				sign=(strs[i++]=='+'?1:-1);
		}
		
		while(i<strs.length) {
			int s=strs[i]-'0';
			if(s>9||s<0) break;
			
	        if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE %10 < s) {
				return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			
			result=result*10+(strs[i++]-'0');
		}
		return result*sign;
	}
	@Test
	public void test() throws Exception {
		System.out.println(Integer.MIN_VALUE/10);
		System.out.println(myAtoi("-91283472332"));
	}
}
