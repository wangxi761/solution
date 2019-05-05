package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubsetsIITest {

	@Test
	public void subsetsWithDup() {
		SubsetsII subsetsII = new SubsetsII();
		subsetsII.subsetsWithDup(new int[]{4, 4, 4, 1, 4})
		         .forEach(System.out::println);
	}
}