package topic.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTest {
	HouseRobber test = new HouseRobber();
	
	@Test
	public void rob() {
		assertEquals(4, test.rob(new int[]{1, 2, 3, 1}));
	}
}