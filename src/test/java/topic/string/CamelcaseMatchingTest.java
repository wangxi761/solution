package topic.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CamelcaseMatchingTest {
	CamelcaseMatching test = new CamelcaseMatching();
	
	@Test
	public void camelMatch() {
		String[] arr = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
		test.camelMatch(arr, "FoBaT")
		    .forEach(System.out::println);
	}
}