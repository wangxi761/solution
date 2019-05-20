package topic.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class GroupsofSpecialEquivalentStringsTest {
	GroupsofSpecialEquivalentStrings test = new GroupsofSpecialEquivalentStrings();
	@Test
	public void testNumSpecialEquivGroups() {
		assertEquals(3, test.numSpecialEquivGroups(
				new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}));
	}

}
