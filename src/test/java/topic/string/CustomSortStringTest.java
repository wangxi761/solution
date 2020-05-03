package topic.string;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.jupiter.api.Test;

public class CustomSortStringTest {
	CustomSortString test =new CustomSortString();
	@Test
	public void testCustomSortString() {
		
		
		assertEquals("cbad", test.customSortString("cba", "abcd"));
	}

}
