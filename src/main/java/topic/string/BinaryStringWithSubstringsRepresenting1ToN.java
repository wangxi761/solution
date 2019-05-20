package topic.string;

public class BinaryStringWithSubstringsRepresenting1ToN {
	public boolean queryString(String S, int N) {
		for (int i = N; i >N/2; i--) {
			String str = Integer.toBinaryString(i);
			if(!S.contains(str))
				return false;
		}
		return true;
	}
}
