package topic.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestFlightsWithinKStopsTest {
	CheapestFlightsWithinKStops test = new CheapestFlightsWithinKStops();
	
	@Test
	public void findCheapestPrice() {
		assertEquals(500, test.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
		assertEquals(200, test.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
	}
}