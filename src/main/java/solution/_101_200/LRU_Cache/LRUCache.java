package solution._101_200.LRU_Cache;

import java.util.LinkedHashMap;
import java.util.LinkedList;

class LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private int capacity;
	
	public LRUCache(int capacity) {
		this.map = new LinkedHashMap<>(capacity);
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			int num = map.remove(key);
			map.put(key, num);
			return num;
		}
		return -1;
	}
	
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
		} else if (map.size() == capacity) {
			map.remove(map.keySet().iterator().next());
		}
		map.put(key, value);
	}
}