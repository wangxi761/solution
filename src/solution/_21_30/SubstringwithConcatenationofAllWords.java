package solution._21_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class SubstringwithConcatenationofAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		String wordSum = String.join("", words);
		int length = wordSum.length();
		Map<Character, List<String>> map = makeMap(words);
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)) && s.length() - i >= length) {
				String sub = s.substring(i, i + length);
				if (compare(sub, makeMap(words))) {
					result.add(i);
				}
			}
		}
		return result;
	}

	private Map<Character, List<String>> makeMap(String[] words) {
		Map<Character, List<String>> map = new HashMap<>();
		for (int index = 0; index < words.length; index++) {
			List<String> list = map.computeIfAbsent(words[index].charAt(0), v -> new ArrayList<>());
			list.add(words[index]);
		}
		return map;
	}

	public boolean compare(String sub, Map<Character, List<String>> map) {
		if (sub.length() == 0 && map.isEmpty()) {
			return true;
		} else if (sub.length() == 0 && !map.isEmpty()) {
			return false;
		} else if (sub.length() != 0 && map.isEmpty()) {
			return false;
		} else {
			char c = sub.charAt(0);
			List<String> list = map.get(c);
			if (list == null)
				return false;
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i);
				if (!sub.startsWith(word))
					continue;
				list.remove(i);
				if (list.isEmpty())
					map.remove(c);
				return compare(sub.substring(word.length()), map);
			}
			return false;
		}
	}
//	public boolean compare(String sub, Map<Character, List<String>> map) {
//		if (sub.length() == 0 && map.isEmpty()) {
//			return true;
//		} else if (sub.length() == 0 && !map.isEmpty()) {
//			return false;
//		} else if (sub.length() != 0 && map.isEmpty()) {
//			return false;
//		} else {
//			char c = sub.charAt(0);
//			List<String> list = map.get(c);
//			if (list == null)
//				return false;
//			for (int i = 0; i < list.size(); i++) {
//				String word = list.get(i);
//				if (!sub.startsWith(word))
//					continue;
//				list.remove(i);
//				if (list.isEmpty())
//					map.remove(c);
//				return compare(sub.substring(word.length()), map);
//			}
//			return false;
//		}
//	}

	@Test
	public void test() throws Exception {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> result = findSubstringI(s, words);
		System.out.println(result);
	}

	public List<Integer> findSubstringI(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || words.length == 0)
			return result;
		int len = words[0].length();
		Map<String, Integer> countMap = new HashMap<>();
		for (String i : words) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
		}
		for (int i = 0; i < s.length() - len * words.length + 1; i++) {
			Map<String, Integer> tempMap = new HashMap<>();
			int j = 0;
			while (j < words.length) {
				String sub = s.substring(i + j * len, i + j * len + len);
				if (countMap.containsKey(sub)) {
					tempMap.put(sub, tempMap.getOrDefault(sub, 0) + 1);
					if (tempMap.get(sub) > countMap.get(sub)) {
						break;
					}
				} else {
					break;
				}
				j++;
			}
			if (j == words.length)
				result.add(i);
		}
		return result;
	}
}
