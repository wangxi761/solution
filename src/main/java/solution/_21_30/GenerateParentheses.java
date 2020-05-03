package solution._21_30;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {
	
	@Test
	public void test() throws Exception {
		List<String> list = generateParenthesis(2);
		System.out.println(list);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> list=new ArrayList<>();
		generate(list, "", n, n, n);
		return list;
	}
	public void generate(List<String> list,String str,int left,int rigth,int max) {
		if(left==0&&rigth==0) {
			list.add(str);
			return;
		}
		if(left>0)
			generate(list, str+"(", left-1, rigth, max);
		if(rigth>0&&left<rigth) {
			generate(list,str+")",left,rigth-1,max);
		}
	}
}
