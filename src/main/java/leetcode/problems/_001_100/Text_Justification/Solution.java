package leetcode.problems._001_100.Text_Justification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> lines = new ArrayList<>();
		int start = 0, len = -1;
		for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
			String word = words[i];
			if (len + word.length() + 1 > maxWidth) {
				lines.add(singleLine(words, maxWidth, start, i));
				start = i;
				len = word.length();
			} else {
				len += word.length() + 1;
			}
		}
		if (start < words.length) {
			lines.add(singleLine(words, maxWidth, start, words.length));
		}
		return lines;
	}
	
	public String singleLine(String[] words, int maxWidth, int start, int end) {
		StringBuilder sb = new StringBuilder();
		if (end == words.length) {
			for (int i = start; i < end; i++) {
				sb.append(words[i]);
				maxWidth -= words[i].length();
				if (maxWidth > 0) {
					sb.append(" ");
					maxWidth--;
				}
			}
			for (int i = 0; i < maxWidth; i++) {
				sb.append(" ");
			}
		} else if (end - start == 1) {
			sb.append(words[start]);
			for (int i = 0; i < maxWidth - words[start].length(); i++) {
				sb.append(" ");
			}
		} else {
			int wordLen = 0;
			for (int i = start; i < end; i++) {
				wordLen += words[i].length();
			}
			int interval = (maxWidth - wordLen) / (end - start - 1);
			int last = (maxWidth - wordLen) % (end - start - 1);
			for (int i = start; i < end; i++) {
				sb.append(words[i]);
				if (i == end - 1) continue;
				for (int j = 0; j < interval; j++) {
					sb.append(" ");
				}
				if (i < end - 1 && last > 0) {
					sb.append(" ");
					last--;
				}
			}
		}
		return sb.toString();
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
		//Output:
		//[
		//   "This    is    an",
		//   "example  of text",
		//   "justification.  "
		//]
		//Example 2:
		//
		//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
		//Output:
		//[
		//  "What   must   be",
		//  "acknowledgment  ",
		//  "shall be        "
		//]
		//Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
		//Note that the second line is also left-justified because it contains only one word.
		//Example 3:
		//
		//Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
		//Output:
		//[
		//  "Science  is  what we",
		//  "understand      well",
		//  "enough to explain to",
		//  "a  computer.  Art is",
		//  "everything  else  we",
		//  "do                  "
		//]
		Assertions.assertEquals(List.of("This    is    an", "example  of text", "justification.  "), fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
		Assertions.assertEquals(List.of("What   must   be", "acknowledgment  ", "shall be        "), fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
		Assertions.assertEquals(List.of("Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  "), fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
	}
}