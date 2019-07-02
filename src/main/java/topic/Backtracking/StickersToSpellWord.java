package topic.Backtracking;

public class StickersToSpellWord {
	public int minStickers(String[] stickers, String target) {
		if (target.isEmpty()) return 0;
		int[] ch = new int[26];
		for (int i = 0; i < target.length(); i++) {
			ch[target.charAt(i) - 'a']++;
		}
		int[][] letters = new int[stickers.length][26];
		for (int i = 0; i < stickers.length; i++) {
			for (int j = 0; j < stickers[i].length(); j++) {
				int index = stickers[i].charAt(j) - 'a';
				if (ch[index] > 0) {
					letters[i][index]++;
				}
			}
		}
		return dfs(letters, ch, 0, false, true);
	}
	
	private int dfs(int[][] stickers, int[] target, int num, boolean zero, boolean changed) {
		if (zero) {
			return num;
		} else if (!changed) {
			return -1;
		}
		
		int res = -1;
		for (int i = 0; i < stickers.length; i++) {
			changed = false;
			zero = true;
			for (int j = 0; j < stickers[i].length; j++) {
				int next = target[j] - stickers[i][j];
				if (target[j] > 0 && next != target[j]) changed = true;
				target[j] = next;
				if (target[j] > 0) zero = false;
			}
			
			int next = dfs(stickers, target, num + 1, zero, changed);
			res = res < 0 || next < 0 ? Math.max(res, next) : Math.min(res, next);
			
			for (int j = 0; j < stickers[i].length; j++) {
				target[j] += stickers[i][j];
			}
		}
		return res;
	}
	
	
	private int recursive1(String[] stickers, int[] target, int num) {
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
			int next = recursive1(stickers, target, num + 1);
			min = min < 0 ? next : Math.min(min, next);
			for (int j = 0; j < stickers[i].length(); j++) {
				target[stickers[i].charAt(j) - 'a']--;
			}
		}
		return min;
	}
	
	private int dfs1(int[][] stickers, int[] target, int num, boolean changed, boolean allZero) {
		if (allZero) return num;
		if (!changed) return -1;
		int min = -1;
		for (int i = 0; i < stickers.length; i++) {
			changed = false;
			allZero = true;
			for (int j = 0; j < stickers[i].length; j++) {
				if (target[i] > 0) {
					allZero = false;
				}
				if (stickers[i][j] == 0) continue;
				int tmp = target[j];
				target[j] -= stickers[i][j];
				changed = target[j] != tmp;
			}
			int next = dfs1(stickers, target, num + 1, changed, allZero);
			min = min < 0 ? next : Math.min(min, next);
			for (int j = 0; j < stickers[i].length; j++) {
				if (target[j] == 0) continue;
				if (stickers[i][j] == 0) continue;
				target[j] += stickers[i][j];
			}
		}
		return min;
	}
	
}
