package array;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int current = digits[i] + carry;
			if (current > 9) {
				current = 0;
				carry = 1;
			} else {
				carry = 0;
			}
			digits[i] = current;
			
		}
		if (carry==1) {
			int[] res = new int[digits.length + 1];
			System.arraycopy(digits, 0, res, 1, digits.length);
			res[0] = carry;
			return res;
		} else {
			return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {9};
		PlusOne plusOne = new PlusOne();
		int[] res = plusOne.plusOne(arr);
		System.out.println(Arrays.toString(res));
	}
	
}
