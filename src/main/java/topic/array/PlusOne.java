package topic.array;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		return reAdd(digits, digits.length-1);
	}
	public int[] reAdd(int[] digits,int index) {
		if(index==-1) {
			int[] newDigits=new int[digits.length+1];
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			newDigits[0]=1;
			return newDigits;
		}
		if(digits[index]==9) {
			digits[index]=0;
			digits=reAdd(digits, --index);
		}else {
			digits[index]+=1;
		}
		return digits;
	}
	
}
