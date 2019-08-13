package topic.sort;

import org.junit.Test;
import util.ArrayUtil;

import static org.junit.Assert.*;

public class DistantBarcodesTest {
	DistantBarcodes test = new DistantBarcodes();
	
	@Test
	public void rearrangeBarcodes() {
		ArrayUtil.prettyPrint(test.rearrangeBarcodes(new int[]{1, 1, 2}));
	}
}