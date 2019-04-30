package topic.array;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		int min = heights[0], max = 0;
		for (int i = 0; i < heights.length; i++) {
			min = Math.min(heights[i], min);
			max = Math.max(max, min * (i+1));
		}
		return max;
	}
}
