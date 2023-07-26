package leetcode.problems._1801_1900.Minimum_Speed_to_Arrive_on_Time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int minSpeedOnTime(int[] dist, double hour) {
		int res = -1;
		int l = 1, r = 10000000;
		while (l <= r) {
			int i = (l + r) / 2;
			double time = time(dist, i);
			if (time > hour) {
				l = i + 1;
			} else {
				r = i - 1;
				res = i;
			}
		}
		return res;
	}
	
	public double time(int[] dist, int speed) {
		double sum = 0;
		for (int i = 0; i < dist.length - 1; i++) {
			sum += Math.ceil(((double) dist[i]) / speed);
		}
		sum += ((double) dist[dist.length - 1]) / speed;
		return sum;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: dist = [1,3,2], hour = 6
		//Output: 1
		//Explanation: At speed 1:
		//- The first train ride takes 1/1 = 1 hour.
		//- Since we are already at an integer hour, we depart immediately at the 1 hour mark. The second train takes 3/1 = 3 hours.
		//- Since we are already at an integer hour, we depart immediately at the 4 hour mark. The third train takes 2/1 = 2 hours.
		//- You will arrive at exactly the 6 hour mark.
		Assertions.assertEquals(1, minSpeedOnTime(new int[]{1, 3, 2}, 6));
		
		//Example 2:
		//
		//Input: dist = [1,3,2], hour = 2.7
		//Output: 3
		//Explanation: At speed 3:
		//- The first train ride takes 1/3 = 0.33333 hours.
		//- Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
		//- Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
		//- You will arrive at the 2.66667 hour mark.
		Assertions.assertEquals(3, minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
		
		//Example 3:
		//
		//Input: dist = [1,3,2], hour = 1.9
		//Output: -1
		//Explanation: It is impossible because the earliest the third train can depart is at the 2 hour mark.
		Assertions.assertEquals(-1, minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
	}
}
