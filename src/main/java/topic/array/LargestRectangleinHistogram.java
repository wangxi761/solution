package topic.array;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		int  max = 0;
		for (int i = 0; i < heights.length; i++) {
			int min = heights[i];
			for (int j = i; j < heights.length; j++) {
				min = Math.min(heights[j], min);
				max = Math.max(max, min * (j-i+1));
			}
		}
		return max;
	}
}
