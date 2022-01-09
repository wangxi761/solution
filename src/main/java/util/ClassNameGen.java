package util;

public class ClassNameGen {
	public static void main(String[] args) {
		String origin_name = "Check if Every Row and Column Contains All Numbers\n";
		StringBuilder sb = new StringBuilder();
		char[] chars = origin_name.toCharArray();
		boolean firstLetter = false;
		for (int i = 0; i < chars.length; i++) {
			if (!firstLetter) {
				if (Character.isLetter(chars[i])) {
					sb.append(Character.toUpperCase(chars[i]));
					firstLetter = true;
				}
				continue;
				
			}
			if (Character.isLetterOrDigit(chars[i])) {
				sb.append(chars[i]);
			}
		}
		System.out.println(sb);
	}
}
