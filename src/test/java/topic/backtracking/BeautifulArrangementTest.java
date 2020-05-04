package topic.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeautifulArrangementTest {
	topic.backtracking.BeautifulArrangement test = new topic.backtracking.BeautifulArrangement();
	
	@Test
	public void countArrangement() {
		assertEquals(2, test.countArrangement(2));
	}
}