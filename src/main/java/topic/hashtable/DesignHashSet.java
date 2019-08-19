package topic.hashtable;

public class DesignHashSet {
	static class MyHashSet {
		int[] res;
		
		/**
		 * Initialize your data structure here.
		 */
		public MyHashSet() {
			res = new int[1000001];
		}
		
		public void add(int key) {
			res[key] = 1;
		}
		
		public void remove(int key) {
			res[key] = 0;
		}
		
		/**
		 * Returns true if this set contains the specified element
		 */
		public boolean contains(int key) {
			return res[key] == 1;
		}
	}
}
