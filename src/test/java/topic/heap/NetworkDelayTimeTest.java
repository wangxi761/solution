package topic.heap;

import org.junit.Test;

public class NetworkDelayTimeTest {
	NetworkDelayTime test = new NetworkDelayTime();
	
	@Test
	public void networkDelayTime() {
		System.out.println(test.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
	}
}