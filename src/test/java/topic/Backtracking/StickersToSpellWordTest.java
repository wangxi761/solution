package topic.backtracking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StickersToSpellWordTest {
	StickersToSpellWord test = new StickersToSpellWord();
	
	@Test
	public void minStickers() {
		assertEquals(3, test.minStickers(new String[]{"with", "example", "science"}, "thehat"));
		assertEquals(-1, test.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
	}
	
	@Test
	public void bitOperate() {
		assertEquals(0, 4 & 3);
		assertEquals(8, 1 << "aaa".length());
	}
}