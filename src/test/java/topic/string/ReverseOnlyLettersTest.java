package topic.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseOnlyLettersTest {
	ReverseOnlyLetters test = new ReverseOnlyLetters();
	
	@Test
	public void reverseOnlyLetters() {
		assertEquals("j-Ih-gfE-dCba", test.reverseOnlyLetters("a-bC-dEf-ghIj"));
//		assertTrue(Character.isLetter('a'));
	}
}