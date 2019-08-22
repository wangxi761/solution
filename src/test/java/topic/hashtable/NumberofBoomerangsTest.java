package topic.hashtable;

import org.junit.Test;

public class NumberofBoomerangsTest {
	NumberofBoomerangs test = new NumberofBoomerangs();
	
	@Test
	public void numberOfBoomerangs() {
		System.out.println(test.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
	}
}