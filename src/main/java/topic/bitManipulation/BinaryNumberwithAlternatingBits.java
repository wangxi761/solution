package topic.bitManipulation;

public class BinaryNumberwithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		int i = n ^ (n >> 1);
		return ((i + 1) & i) == 0;
	}
}