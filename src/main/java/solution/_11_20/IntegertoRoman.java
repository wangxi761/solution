package solution._11_20;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IntegertoRoman {

	@Test
	public void test() throws Exception {
		assertArrayEquals(new String[] {"III","IV","IX","LVIII","MCMXCIV"}, new String[] {
				intToRoman(3),
				intToRoman(4),
				intToRoman(9),
				intToRoman(58),
				intToRoman(1994),
		});
	}
	public String intToRoman(int num) {
		String[] a= {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String[] b= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] c= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] d= {"","M","MM","MMM"};
		String e=d[num/1000]+c[num/100%10]+b[num/10%10]+a[num%10];
		return e;
	}
}
