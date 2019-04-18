package topic.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PlusOneTest {

	@Test
	public void testPlusOne() {
		PlusOne one=new PlusOne();
		System.out.println(Arrays.toString(one.plusOne(new int[] {9,9,9})));
	}

}
