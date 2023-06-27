package solution._301_400.Find_K_Pairs_with_Smallest_Sums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		// Priority queue to store pairs with smallest sums, sorted by the sum
		
		// Push the initial pairs into the priority queue
		for (int x : nums1) {
			pq.offer(new int[]{x + nums2[0], 0}); // The sum and the index of the second element in nums2
		}
		
		// Pop the k smallest pairs from the priority queue
		while (k > 0 && !pq.isEmpty()) {
			int[] pair = pq.poll();
			int sum = pair[0]; // Get the smallest sum
			int pos = pair[1]; // Get the index of the second element in nums2
			
			List<Integer> currentPair = new ArrayList<>();
			currentPair.add(sum - nums2[pos]);
			currentPair.add(nums2[pos]);
			resV.add(currentPair); // Add the pair to the result list
			
			// If there are more elements in nums2, push the next pair into the priority queue
			if (pos + 1 < nums2.length) {
				pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
			}
			
			k--; // Decrement k
		}
		
		return resV; // Return the k smallest pairs
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 4), Arrays.asList(1, 6)), kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
		Assertions.assertEquals(Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 1)), kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
		Assertions.assertEquals(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 3)), kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
	}
}
