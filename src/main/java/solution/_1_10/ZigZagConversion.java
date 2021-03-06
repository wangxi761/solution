package solution._1_10;


public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}

		int i = 0;
		while (i < len) {
			for (int j = 0; j < numRows && i < len; j++) {
				sb[j].append(c[i++]);
			}
			for (int j = numRows - 2; j >= 1 && i < len; j--) {
				sb[j].append(c[i++]);
			}
		}
		for (int j = 1; j < sb.length; j++) {
			sb[0].append(sb[j]);
		}
		return sb[0].toString();
	}
}
