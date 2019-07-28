package topic.bitManipulation;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
	}
}
