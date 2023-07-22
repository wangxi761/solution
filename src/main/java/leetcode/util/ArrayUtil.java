package leetcode.util;

import java.util.Arrays;

public class ArrayUtil {
	
	public static void prettyPrint(int[][] ts) {
		System.out.println("");
		Arrays.stream(ts).map(Arrays::toString).forEach(System.out::println);
		System.out.println("");
	}
	
	public static <T> void prettyPrint(T[][] ts) {
		System.out.println("");
		Arrays.stream(ts).map(Arrays::toString).forEach(System.out::println);
		System.out.println("");
	}
	
	public static <T> void prettyPrint(int[] ts) {
		System.out.println("");
		System.out.println(Arrays.toString(ts));
		System.out.println("");
	}
	
	public static <T> void prettyPrint(T[] ts) {
		System.out.println("");
		System.out.println(Arrays.toString(ts));
		System.out.println("");
	}
}
