package topic.string;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;

public class CustomSortString {
	public String customSortString1(String S, String T) {
		return T.chars()
				.mapToObj(i->(char)i)
				.sorted(Comparator.comparing(i->S.indexOf(i)))
				.map(i -> String.valueOf(i))
				.collect(joining());
	}
	public String customSortString(String S, String T) {
		StringBuilder sb=new StringBuilder();
		int[] arr=new int[26];
		for (Character i : T.toCharArray()) {
			arr[i-'a']++;
		}
		
		for (Character i : S.toCharArray()) {
			while(arr[i-'a']-->0) sb.append(i);
		}
		for (int i = 0; i < arr.length; i++) {
			while(arr[i]-->0) sb.append((char)('a'+i));
		}
		return sb.toString();
	}
}
