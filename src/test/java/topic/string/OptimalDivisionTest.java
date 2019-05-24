package topic.string;

import org.junit.Test;

public class OptimalDivisionTest {
	OptimalDivision test = new OptimalDivision();
	
	@Test
	public void optimalDivision() {
		System.out.println(test.optimalDivision(new int[]{1000, 100, 10, 2}));
	}
}