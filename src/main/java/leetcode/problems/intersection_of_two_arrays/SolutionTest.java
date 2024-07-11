package leetcode.problems.intersection_of_two_arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void findsIntersectionInTwoArrays() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution.intersection(nums1, nums2));
    }

    @Test
    public void findsIntersectionInTwoDifferentArrays() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] expected = {9, 4};
        Assertions.assertArrayEquals(expected, solution.intersection(nums1, nums2));
    }

    @Test
    public void returnsEmptyArrayForNonIntersectingArrays() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution.intersection(nums1, nums2));
    }

    @Test
    public void handlesEmptyArray1() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution.intersection(nums1, nums2));
    }

    @Test
    public void handlesEmptyArray2() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution.intersection(nums1, nums2));
    }

    @Test
    public void handlesBothArraysBeingEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution.intersection(nums1, nums2));
    }
}