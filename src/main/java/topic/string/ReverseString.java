package topic.string;

public class ReverseString {
	public void reverseString(char[] s) {
		reverse(s, 0, s.length - 1);
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
