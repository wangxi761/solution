package topic.hashtable;

import java.util.Arrays;

public class DesignHashMap {
	
	private int[] res;
	
	/**
	 * Initialize your data structure here.
	 */
	public DesignHashMap() {
		res = new int[1000001];
	}
	
	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		res[key] = value + 1;
	}
	
	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		return res[key] - 1;
	}
	
	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		res[key] = 0;
	}
}
