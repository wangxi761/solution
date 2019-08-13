package topic.sort;

import java.util.Arrays;

public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int[] counts = new int[10001];
		for (int i = 0; i < barcodes.length; i++) {
			counts[barcodes[i]]++;
		}
		for (int i = 0; i < counts.length; i++) {
			counts[i] = counts[i] * 100000 + i;
		}
		Arrays.sort(counts);
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			int size = counts[i] / 100000;
			int num = counts[i] % 100000;
			for (int j = 0; j < size; j++) {
				barcodes[index++] = num;
			}
		}
		int i = 1;
		int[] res = new int[barcodes.length];
		for (int j = 0; j < barcodes.length; j++) {
			if (i >= barcodes.length) i = 0;
			res[i] = barcodes[j];
			i += 2;
		}
		return res;
	}
}
