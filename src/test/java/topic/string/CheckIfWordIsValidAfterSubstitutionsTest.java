package topic.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckIfWordIsValidAfterSubstitutionsTest {
	CheckIfWordIsValidAfterSubstitutions test = new CheckIfWordIsValidAfterSubstitutions();
	
	@Test
	public void isValid() {
		assertTrue(test.isValid("aabcbc"));
		assertTrue(test.isValid("abcabcababcc"));
		assertFalse(test.isValid("abccba"));
		assertFalse(test.isValid("cababc"));
	}
}