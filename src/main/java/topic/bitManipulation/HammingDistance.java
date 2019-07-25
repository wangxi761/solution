package topic.bitManipulation;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int num = x ^ y;
		int sum = 0;
		while (num > 0) {
			sum += num & 1;
			num = num >> 1;
		}
		return sum;
	}
	
	public int hammingDistance1(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}
