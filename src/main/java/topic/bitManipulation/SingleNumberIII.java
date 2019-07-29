package topic.bitManipulation;

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num ^= nums[i];
		}
		num &= -num;
		int[] res = {0, 0};
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & num) == 0) {
				res[0] ^= nums[i];
			} else {
				res[1] ^= nums[i];
			}
		}
		return res;
	}
}
