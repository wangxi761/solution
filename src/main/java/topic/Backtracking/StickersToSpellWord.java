package topic.Backtracking;

public class StickersToSpellWord {
	public int minStickers(String[] stickers, String target) {
		return recursive(stickers, count(target), 0);
	}
	
	private int[] count(String str) {
		int[] ch = new int[26];
		for (int i = 0; i < str.length(); i++) {
			ch[str.charAt(i) - 'a']++;
		}
		return ch;
	}
	
	private int recursive(String[] stickers, int[] target, int num) {
		boolean tag = false;
		for (int i = 0; i < target.length; i++) {
			if (target[i] < 0) return -1;
			if (target[i] != 0) tag = true;
		}
		if (!tag) return num;
		int min = -1;
		for (int i = 0; i < stickers.length; i++) {
			for (int j = 0; j < stickers[i].length(); j++) {
				target[stickers[i].charAt(j) - 'a']++;
			}
			int next = recursive(stickers, target, num + 1);
			min = min < 0 ? next : Math.min(min, next);
			for (int j = 0; j < stickers[i].length(); j++) {
				target[stickers[i].charAt(j) - 'a']--;
			}
		}
		return min;
	}
	
}
