package study.recursion;

public class KthSymbolinGrammar {
	public int kthGrammar(int N, int K) {
		int state = 0;
		for (char c : Integer.toBinaryString(K - 1).toCharArray()) {
			state = state(state, c);
		}
		return state;
	}
	
	public int state(int state, char input) {
		if (input == '0') {
			return state;
		} else {
			return state == 0 ? 1 : 0;
		}
	}
}
