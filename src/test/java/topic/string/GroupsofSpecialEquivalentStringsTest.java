package topic.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GroupsofSpecialEquivalentStringsTest {
	GroupsofSpecialEquivalentStrings test = new GroupsofSpecialEquivalentStrings();
	@Test
	public void testNumSpecialEquivGroups() {
		assertEquals(3, test.numSpecialEquivGroups(
				new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}));
	}

}
