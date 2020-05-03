package study.dp.pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletePackTest {
	CompletePack test = new CompletePack();
	
	@Test
	public void solution() {
		int[] c = {2, 3, 4, 7};
		int[] w = {1, 3, 5, 9};
		assertEquals(12, test.solution1(w, c, 10));
	}
}