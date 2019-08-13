package topic.sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarFleetTest {
	CarFleet test = new CarFleet();
	
	@Test
	public void carFleet() {
		assertEquals(3, test.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
	}
}