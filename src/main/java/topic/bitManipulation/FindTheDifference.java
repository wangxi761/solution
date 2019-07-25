package topic.bitManipulation;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		int c = 0;
		for (char i : s.toCharArray()) {
			c ^= i;
		}
		for (char i : t.toCharArray()) {
			c ^= i;
		}
		return (char) c;
	}
}
