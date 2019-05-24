package topic.string;

public class OptimalDivision {
	public String optimalDivision(int[] nums) {
		if (nums.length == 1) {
			return String.valueOf(nums[0]);
		} else if (nums.length == 2) {
			return nums[0] + "/" + nums[1];
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i < nums.length; i++) {
				sb.append("/" + nums[i]);
			}
			return nums[0] + "/(" + nums[1] + sb.toString() + ")";
		}
	}
}
