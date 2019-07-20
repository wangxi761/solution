package topic.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumASCIIDeleteSumForTwoStringsTest {
	MinimumASCIIDeleteSumForTwoStrings test = new MinimumASCIIDeleteSumForTwoStrings();
	
	@Test
	public void minimumDeleteSum() {
		assertEquals(231, test.minimumDeleteSum("sea", "eat"));
		assertEquals(403, test.minimumDeleteSum("delete", "leet"));
		assertEquals(1399, test.minimumDeleteSum("ccaccjp", "fwosarcwge"));
	}
}