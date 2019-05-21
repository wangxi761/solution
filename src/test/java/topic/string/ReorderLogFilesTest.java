package topic.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReorderLogFilesTest {
	ReorderLogFiles test = new ReorderLogFiles();
	
	@Test
	public void reorderLogFiles() {
		String[] actual = test.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
		System.out.println(Arrays.toString(actual));
	}
}