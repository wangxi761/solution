package topic.string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindandReplacePattern_890 {

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		pattern=convert(pattern);
		List<String> list=new ArrayList<>();
		for (String i : words) {
			String convert = convert(i);
			if(convert.equals(pattern)) {
				list.add(i);
			}
		}
		return list;
	}
	public String convert(String word) {
		Map<Character, Character> map=new HashMap<Character, Character>();
		char[] arr = word.toCharArray();
		for (int j = 0; j < arr.length; j++) {
			if(!map.containsKey(arr[j])) {
				map.put(arr[j], (char)('a'+map.size()));
			}
			arr[j]=map.get(arr[j]);
		}
		return new String(arr);
	}
	
	
	
	
	@Test
	public void test() throws Exception {
		String[] words= {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern="abb";
		List<String> list = findAndReplacePattern(words, pattern);
		assertEquals(2, list.size());
	}
}
