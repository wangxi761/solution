package topic.hashtable;

public class FindWordsThatCanBeFormedbyCharacters {
	public int countCharacters(String[] words, String chars) {
		int[] origin = new int[26];
		set(origin, chars);
		int res = 0;
		OUT:
		for (String word : words) {
			int[] compare = new int[26];
			set(compare, word);
			for (int i = 0; i < origin.length; i++) {
				if (origin[i] < compare[i])
					continue OUT;
			}
			res += word.length();
		}
		return res;
	}
	
	public void set(int[] nums, String str) {
		for (char c : str.toCharArray()) {
			nums[c - 'a']++;
		}
	}
}
