package topic.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsinaStringIIITest {
	ReverseWordsinaStringIII test = new ReverseWordsinaStringIII();
	@Test
	public void testReverseWords() {
		assertEquals("s'teL ekat edoCteeL tsetnoc",
				test.reverseWords("Let's take LeetCode contest"));
	}

}
