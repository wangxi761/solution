package topic.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsofSpecialEquivalentStrings {
	public int numSpecialEquivGroups(String[] A) {
		Set<String> set=new HashSet<>();
		for (String str : A) {
			int[] arr=new int[52];
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i)-'a'+26*(i%2)]++;
			}
			set.add(Arrays.toString(arr));
		}
		return set.size();
	}
}
