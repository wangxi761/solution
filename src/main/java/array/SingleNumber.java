package array;

import java.util.Arrays;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		return Arrays.stream(nums).reduce((left, right) -> left ^ right).getAsInt();
	}
	
	public static void main(String[] args) {
		SingleNumber singleNumber=new SingleNumber();
		int i = singleNumber.singleNumber(new int[]{1});
		System.out.println(0^0);
	}
}
