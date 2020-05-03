package topic.Backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StickersToSpellWordTest {
	topic.backtracking.StickersToSpellWord test = new topic.backtracking.StickersToSpellWord();
	
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