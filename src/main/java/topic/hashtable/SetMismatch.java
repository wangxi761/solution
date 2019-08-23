package topic.hashtable;

public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			while (i + 1 != nums[i]) {
				if (nums[i] == nums[nums[i] - 1]) {
					break;
				}
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 != nums[i]) {
				res[0] = nums[i];
				res[1] = i + 1;
			}
		}
		return res;
	}
	
	public void swap(int[] nums, int i, int j) {
		int data = nums[i];
		nums[i] = nums[j];
		nums[j] = data;
	}
	
	public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;
	}
}
