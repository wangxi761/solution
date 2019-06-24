package topic.Backtracking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeautifulArrangementTest {
	BeautifulArrangement test = new BeautifulArrangement();
	
	@Test
	public void countArrangement() {
		assertEquals(2, test.countArrangement(2));
	}
}