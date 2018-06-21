package solution._11_20;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class RomantoInteger {

	@Test
	public void test() throws Exception {
		Assert.assertArrayEquals(new int[] { 3, 4, 9, 58, 1994 }, new int[] { romanToInt("III"), romanToInt("IV"),
				romanToInt("IX"), romanToInt("LVIII"), romanToInt("MCMXCIV") });
	}

	public int romanToInt(String s) {
		Map<Integer, String[]> map = new LinkedHashMap<Integer, String[]>() {
			private static final long serialVersionUID = 1L;
			{
				put(1000, new String[]{ "", "M", "MM", "MMM" });
				put(100, new String[]{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" });
				put(10, new String[]{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" });
				put(1, new String[]{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" });
			}
		};
		int num = 0;
		for (Map.Entry<Integer, String[]> m : map.entrySet()) {
			for (int i = m.getValue().length-1; i >0 ; i--) {
				if (s.startsWith(m.getValue()[i])) {
					num += m.getKey() * i;
					s = s.substring(m.getValue()[i].length());
				}
			}
		}
		return num;
	}
}
