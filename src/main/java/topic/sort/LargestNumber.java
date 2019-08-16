package topic.sort;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int maxIdx = i;
			for (int j = i; j < nums.length; j++) {
				if (big(nums[j], nums[maxIdx])) {
					maxIdx = j;
				}
			}
			if (i != maxIdx) swap(nums, i, maxIdx);
		}
		StringBuilder sb = new StringBuilder();
		for (int num : nums) {
			sb.append(num);
		}
		if (sb.charAt(0) == '0') {
			return "0";
		}
		return sb.toString();
	}
	
	public boolean big(int a, int b) {
		return a * Math.pow(10, count(b)) + b > b * Math.pow(10, count(a)) + a;
	}
	
	public void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	public int count(int n) {
		return n == 0 ? 1 : (int) (Math.log10(n) + 1);
	}
}
