package topic.bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertANumbertoHexadecimalTest {
	ConvertANumbertoHexadecimal test = new ConvertANumbertoHexadecimal();
	
	@Test
	public void toHex() {
		assertEquals(Integer.toHexString(15), test.toHex(15));
		assertEquals(Integer.toHexString(555), test.toHex(555));
		assertEquals(Integer.toHexString(127), test.toHex(127));
		assertEquals(Integer.toHexString(Integer.MIN_VALUE), test.toHex(Integer.MIN_VALUE));
		assertEquals(Integer.toHexString(-1), test.toHex(-1));
		
	}
	
	
}