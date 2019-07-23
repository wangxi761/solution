package topic.bitManipulation;

public class NumberComplement {
	public int findComplement(int num) {
		int n = 0;
		while (n < num) {
			n = (n << 1) | 1;
		}
		return n - num;
	}
	
	
	public int findComplement1(int num) {
		if (num == 0) {
			return 1;
		}
		int res = 0;
		int count = 0;
		while (num > 0) {
			res += (num & 1) == 1 ? 0 : 1 << count;
			count++;
			num >>= 1;
		}
		return res;
	}
}
