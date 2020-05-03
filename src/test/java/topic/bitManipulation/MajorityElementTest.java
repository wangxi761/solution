package topic.bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementTest {
	MajorityElement test = new MajorityElement();
	
	@Test
	public void majorityElement() {
		assertEquals(3, test.majorityElement(new int[]{2, 2, 3, 3, 2, 4, 3, 3}));
	}
}