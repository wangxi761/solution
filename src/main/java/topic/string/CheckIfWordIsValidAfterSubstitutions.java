package topic.string;

public class CheckIfWordIsValidAfterSubstitutions {
	public boolean isValid(String S) {
		while (true) {
			String newS = S.replace("abc", "");
			if ("".equals(newS)) {
				return true;
			} else if (S.equals(newS)) {
				return false;
			} else {
				S = newS;
			}
		}
	}
}
