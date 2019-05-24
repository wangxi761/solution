package topic.string;

public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String S) {
		char[] chars = S.toCharArray();
		char[] chs = new char[chars.length];
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetter(chars[i])) {
				chs[i] = chars[i];
			} else {
				chs[i] = 'a';
			}
		}
		int i = chars.length - 1, j = 0;
		while (i >= 0 && j < chars.length) {
			if (!Character.isLetter(chars[i])) {
				i--;
			} else if (!Character.isLetter(chs[j])) {
				j++;
			} else {
				chs[j] = chars[i];
				j++;
				i--;
			}
			
		}
		return new String(chs);
	}
}
