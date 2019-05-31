package topic.string;

public class ReverseStringII {
	public String reverseStr(String s, int k) {
		char[] chs = s.toCharArray();
		recursive(chs, k, 0);
		return new String(chs);
	}
	
	public void recursive(char[] chs, int k, int i) {
		if (i >= chs.length) {
			return;
		} else if (chs.length - 1 - i < k) {
			reverse(chs, i, chs.length - 1);
		} else {
			reverse(chs, i, i + k - 1);
			recursive(chs, k, i + k * 2);
		}
	}
	
	public void reverse(char[] chs, int i, int j) {
		while (i < j) {
			char tmp = chs[i];
			chs[i] = chs[j];
			chs[j] = tmp;
			i++;
			j--;
		}
	}
}
