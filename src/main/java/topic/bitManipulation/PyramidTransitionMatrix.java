package topic.bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		Map<String, List<Character>> map = new HashMap<>();
		for (String allow : allowed) {
			String sub = allow.substring(0, 2);
			List<Character> list = map.getOrDefault(sub, new ArrayList<>());
			list.add(allow.charAt(2));
			map.put(sub, list);
		}
		return recursive(map, bottom);
	}
	
	public boolean recursive(Map<String, List<Character>> map, String bottom) {
		if (bottom.length() == 1) return true;
		for (int i = 0; i < bottom.length() - 1; i++) {
			if (!map.containsKey(bottom.substring(i, i + 2))) return false;
		}
		
		List<String> list = new ArrayList<>();
		dfs(bottom, "", 0, list, map);
		for (String s : list) {
			if (recursive(map, s)) return true;
		}
		return false;
	}
	
	public void dfs(String bottom, String above, int idx, List<String> list, Map<String, List<Character>> map) {
		if (idx == bottom.length() - 1) {
			list.add(above);
			return;
		}
		List<Character> li = map.get(bottom.substring(idx, idx + 2));
		for (Character c : li) {
			String temp = above + c;
			dfs(bottom, temp, idx + 1, list, map);
		}
	}
}
