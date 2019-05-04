package topic.array;

public class LargestRectangleinHistogram {
	public int largestRectangleArea1(int[] heights) {
		if (heights.length == 0)
			return 0;
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int min = heights[i];
			for (int j = i; j < heights.length; j++) {
				min = Math.min(heights[j], min);
				max = Math.max(max, min * (j - i + 1));
			}
		}
		return max;
	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
				continue;
			}
			int min = heights[i];
			for (int j = i; j >= 0; j--) {
				min = Math.min(min, heights[j]);
				max = Math.max(max, (i - j + 1) * min);
			}
		}
		return max;
	}
}
