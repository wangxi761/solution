package topic.sort;

public class SortArrayByParityII {
	public int[] sortArrayByParityII(int[] A) {
		int odd = 1, even = 0;
		while (odd < A.length && even < A.length) {
			while (odd < A.length && (A[odd] & 1) != 0) {
				odd += 2;
			}
			while (even < A.length && (A[even] & 1) == 0) {
				even += 2;
			}
			if (odd < A.length && even < A.length) {
				A[odd] = A[odd] ^ A[even];
				A[even] = A[odd] ^ A[even];
				A[odd] = A[odd] ^ A[even];
			}
		}
		return A;
	}
}
