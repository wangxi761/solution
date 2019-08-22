package topic.hashtable;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate1(int[] nums) {
		byte[] bs = new byte[Integer.MAX_VALUE / 8];
		for (int i = 0; i < nums.length; i++) {
			if (isOne(bs[nums[i] / 8], nums[i] % 8)) {
				return true;
			}
			bs[nums[i] / 8] = setOne(bs[nums[i] / 8], nums[i] % 8);
		}
		return false;
	}
	
	public boolean isOne(byte b, int i) {
		return ((b >>> i) & 1) == 1;
	}
	
	public byte setOne(byte b, int i) {
		return (byte) (b | 1 << i);
	}
	
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> sets = new HashSet<>();
		for (int num : nums) {
			if (sets.contains(num)) {
				return true;
			}
			sets.add(num);
		}
		return false;
	}
}