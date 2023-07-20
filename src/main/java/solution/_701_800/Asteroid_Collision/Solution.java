package solution._701_800.Asteroid_Collision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Solution {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			boolean tag = true;
			int num = asteroid;
			while (!stack.isEmpty() && ((stack.peek() > 0 && num < 0))) {
				Integer cur = stack.pop();
				if (Math.abs(cur) > Math.abs(num)) {
					num = cur;
				} else if (Math.abs(cur) == Math.abs(num)) {
					tag = false;
					break;
				}
			}
			if (tag) {
				stack.push(num);
			}
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < stack.size(); i++) {
			res[i] = stack.get(i);
		}
		return res;
	}
	
	
	@Test
	public void test() {
		
		Assertions.assertArrayEquals(new int[]{-2, -1, 1, 2}, asteroidCollision(new int[]{-2, -1, 1, 2}));
		
		//Input: asteroids = [8,-8]
		//Output: []
		//Explanation: The 8 and -8 collide exploding each other.
		Assertions.assertArrayEquals(new int[]{}, asteroidCollision(new int[]{8, -8}));
		
		//Input: asteroids = [5,10,-5]
		//Output: [5,10]
		//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
		Assertions.assertArrayEquals(new int[]{5, 10}, asteroidCollision(new int[]{5, 10, -5}));
		
		//Input: asteroids = [10,2,-5]
		//Output: [10]
		//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
		Assertions.assertArrayEquals(new int[]{10}, asteroidCollision(new int[]{10, 2, -5}));
	}
}