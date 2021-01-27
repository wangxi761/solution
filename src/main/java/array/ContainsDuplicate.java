package array;

import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> sets=new HashSet<>();
		for (int num : nums) {
			int size = sets.size();
			sets.add(num);
			if (size == sets.size()) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(1^2);
	}
}
