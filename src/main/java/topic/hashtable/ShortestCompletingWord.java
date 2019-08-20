package topic.hashtable;

public class ShortestCompletingWord {
	public String shortestCompletingWord(String licensePlate, String[] words) {
		int[] letters = new int[26];
		countChars(letters, licensePlate);
		int min = -1;
		OUT:
		for (int i = 0; i < words.length; i++) {
			if (min != -1 && words[i].length() > words[min].length()) continue;
			int[] compare = new int[26];
			countChars(compare, words[i]);
			for (int j = 0; j < letters.length; j++) {
				if (letters[j] > compare[j]) {
					continue OUT;
				}
			}
			if (min < 0 || words[i].length() < words[min].length()) {
				min = i;
			}
		}
		return min >= 0 ? words[min] : "";
	}
	
	public void countChars(int[] nums, String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isLetter(c)) continue;
			nums[Character.toLowerCase(c) - 'a']++;
		}
	}
}
