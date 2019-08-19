package topic.sort;

public class NRepeatedElementinSize2NArray {
	public int repeatedNTimes(int[] A) {
		int[] nums = new int[10000];
		for (int i : A) {
			nums[i]++;
			if (nums[i] > 1) {
				return i;
			}
		}
		return 0;
	}
	
}
