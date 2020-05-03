package topic.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubsetsIITest {

	@Test
	public void subsetsWithDup() {
		SubsetsII subsetsII = new SubsetsII();
		subsetsII.subsetsWithDup(new int[]{4, 4, 4, 1, 4})
		         .forEach(System.out::println);
	}
}