package topic.bitManipulation;

public class ConvertANumbertoHexadecimal {
	public String toHex(int num) {
		if (num == 0) return "0";
		char[] candidate = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			int p = num & 15;
			sb.insert(0, candidate[p]);
			num >>>= 4;
		}
		return sb.toString();
	}
}
