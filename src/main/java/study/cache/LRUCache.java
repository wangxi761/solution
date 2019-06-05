package study.cache;

import java.util.LinkedList;

public class LRUCache {
	private LinkedList<String> list = new LinkedList<>();
	int max = 5;
	
	public void add(String str) {
		int index = list.indexOf(str);
		if (index == -1 && list.size() == max) {
			list.poll();
		} else if (index != -1) {
			list.remove(index);
		}
		list.offer(str);
	}
	
}
