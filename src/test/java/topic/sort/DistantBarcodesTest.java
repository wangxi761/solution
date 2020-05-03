package topic.sort;

import org.junit.jupiter.api.Test;
import util.ArrayUtil;

import static org.junit.jupiter.api.Assertions.*;

public class DistantBarcodesTest {
	DistantBarcodes test = new DistantBarcodes();
	
	@Test
	public void rearrangeBarcodes() {
		ArrayUtil.prettyPrint(test.rearrangeBarcodes(new int[]{1, 1, 2}));
	}
}