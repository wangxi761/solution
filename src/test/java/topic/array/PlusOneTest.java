package topic.array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PlusOneTest {

	@Test
	public void testPlusOne() {
		PlusOne one=new PlusOne();
		System.out.println(Arrays.toString(one.plusOne(new int[] {9,9,9})));
	}

}
