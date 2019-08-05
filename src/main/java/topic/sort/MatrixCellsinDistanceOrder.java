package topic.sort;

public class MatrixCellsinDistanceOrder {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] res = new int[R * C][2];
		int count = 0;
		for (int i = 0; i <= R + C - 2; i++) {
			for (int x = 0; x <= i; x++) {
				int y = i - x;
				if (x == 0 && y == 0) {
					count = getCount(R, C, res, count, r0, c0);
				} else if (x == 0 && y != 0) {
					count = getCount(R, C, res, count, r0, c0 + y);
					count = getCount(R, C, res, count, r0, c0 - y);
				} else if (x != 0 && y == 0) {
					count = getCount(R, C, res, count, r0 + x, c0);
					count = getCount(R, C, res, count, r0 - x, c0);
				} else {
					count = getCount(R, C, res, count, r0 + x, c0 + y);
					count = getCount(R, C, res, count, r0 - x, c0 + y);
					count = getCount(R, C, res, count, r0 + x, c0 - y);
					count = getCount(R, C, res, count, r0 - x, c0 - y);
				}
			}
		}
		return res;
	}
	
	private int getCount(int R, int C, int[][] res, int count, int x1, int y1) {
		if (x1 >= 0 && x1 < R && y1 >= 0 && y1 < C) {
			res[count][0] = x1;
			res[count][1] = y1;
			count++;
		}
		return count;
	}
}
