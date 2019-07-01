package topic.Backtracking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StickersToSpellWordTest {
	StickersToSpellWord test = new StickersToSpellWord();
	
	@Test
	public void minStickers() {
		assertEquals(3, test.minStickers(new String[]{"with", "example", "science"}, "thehat"));
	}
}