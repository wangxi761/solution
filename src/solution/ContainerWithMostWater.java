package solution;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWater {

	@Test
	public void test() throws Exception {
		int[] arr = new int[] { 1, 2, 4, 3 };
		int a = maxArea(arr);
		Assert.assertTrue(a == 4);
	}

	public int maxArea(int[] height) {
		int max = 0,j = height.length - 1,i=0;
		while(i<j) {
			int t = (j - i) * Math.min(height[i], height[j]);
			max = t > max ? t : max;
			if(height[i]<height[j]) {
				i++;
			}else {
				j--;
			}
		}
		return max;
	}

	public int maxAreaI(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int t = (j - i) * Math.min(height[i], height[j]);
				max = t > max ? t : max;
			}
		}
		return max;
	}
}
