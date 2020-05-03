package topic.bitManipulation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PyramidTransitionMatrixTest {
	PyramidTransitionMatrix test = new PyramidTransitionMatrix();
	
	@Test
	public void pyramidTransition() {
		assertTrue(test.pyramidTransition("BCD", Arrays.asList("BCG", "CDE", "GEA", "FFF")));
	}
}