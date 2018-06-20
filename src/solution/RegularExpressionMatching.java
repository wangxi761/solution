package solution;

import org.junit.Assert;
import org.junit.Test;
/**
 * 模拟正则表达式 "."和"*"的效果
 * @author ccf
 *
 */
public class RegularExpressionMatching {
	
	@Test
	public void test() throws Exception {
		boolean tag=isMatch("aabbcc", "a*b*.*");
		Assert.assertTrue(tag);
				
	}
	
	public boolean isMatch(String s, String p) {
		if(p.isEmpty())
			return s.isEmpty();
		boolean match=!s.isEmpty()&&(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.');
		
		if(p.length()>=2&&p.charAt(1)=='*')
			return isMatch(s, p.substring(2))		//递归匹配后面的
					||(match&&isMatch(s.substring(1), p));
		
		return match&&isMatch(s.substring(1), p.substring(1));
	}
}
