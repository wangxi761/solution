package topic.sort;

import org.junit.Test;
import util.ArrayUtil;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

public class KClosestPointstoOriginTest {
	KClosestPointstoOrigin test = new KClosestPointstoOrigin();
	
	@Test
	public void kClosest() {
		int[] arr = {3, 5, 2, 4, 1};
		test.help(arr, 0, arr.length - 1);
	}
}