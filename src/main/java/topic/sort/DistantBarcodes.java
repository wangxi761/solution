package topic.sort;

import java.util.Arrays;

public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int[] res = new int[barcodes.length];
		Arrays.sort(barcodes);
		int i = 1;
		for (int j = 0; j < barcodes.length; j++) {
			if (i >= barcodes.length) i = 0;
			res[i] = barcodes[j];
			i += 2;
		}
		return res;
	}
}
