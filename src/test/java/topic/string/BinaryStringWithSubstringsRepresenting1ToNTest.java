package topic.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinaryStringWithSubstringsRepresenting1ToNTest {
	BinaryStringWithSubstringsRepresenting1ToN test=new BinaryStringWithSubstringsRepresenting1ToN();
	@Test
	public void testQueryString() {
		assertEquals(true, test.queryString("0110", 3));
	}

}
