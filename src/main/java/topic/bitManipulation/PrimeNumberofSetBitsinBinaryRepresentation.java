package topic.bitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberofSetBitsinBinaryRepresentation {
	public int countPrimeSetBits(int L, int R) {
		Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
		int sum = 0;
		for (int i = L; i <= R; i++) {
			sum += set.contains(Integer.bitCount(i)) ? 1 : 0;
		}
		return sum;
	}
}
