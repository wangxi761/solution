package topic.bitManipulation;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int i = 0;
		for (int num : nums) {
			i |= (1 << (num - 1));
		}
		return i;
	}
}
