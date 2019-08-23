package topic.hashtable;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] letters = new int[52];
		for (char c : s.toCharArray()) {
			if (c < 'a') {
				letters[c - 'A']++;
			} else {
				letters[c - 'a' + 26]++;
			}
		}
		int nums = 0;
		boolean flag = true;
		for (int num : letters) {
			if (num % 2 == 1 && flag) {
				nums += num;
				flag = false;
				continue;
			}
			nums += num - num % 2;
		}
		return nums;
	}
	
}
