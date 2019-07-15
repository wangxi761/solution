package topic.backtracking;

public class CountNumberswithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		int res = 10;
		int a = 9;
		int b = 9;
		while (n > 1 && b > 0) {
			a *= b;
			res += a;
			b--;
			n--;
		}
		return res;
	}
}
