package topic.bitManipulation;

public class MissingNumber {
	public int missingNumber1(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return (nums.length + 1) * nums.length / 2 - sum;
	}
	
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
}
