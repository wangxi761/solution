package topic.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromicSubstringsTest {
	PalindromicSubstrings test=new PalindromicSubstrings();
	@Test
	public void testCountSubstrings() {
		assertEquals(6, test.countSubstrings("abc"));
	}

}
