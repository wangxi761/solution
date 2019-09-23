package study.impl;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Priority_Queue<T> {
	Object[] elementData;
	int size;
	Comparator<T> comparator;
	
	public Priority_Queue() {
		this.size = 11;
		comparator = null;
	}
	
	public boolean offer(T o) {
		if (o == null) throw new NullPointerException();
		if (size >= elementData.length) {
			elementData = Arrays.copyOf(elementData, size + size + 2);
		}
		
		int index = size;
		Comparable<T> key = (Comparable<T>) o;
		while (index > 0) {
			int parent = (size - 1) >>> 1;
			Object p = elementData[parent];
			if (key.compareTo((T) p) >= 0) {
				break;
			}
			elementData[index] = p;
			index = parent;
		}
		elementData[index] = key;
		size++;
		return true;
	}
	
	public T poll() {
		return null;
	}
	
	public T peek() {
		return ((T) elementData[0]);
	}
	
	
	@Test
	public void test() {
	
	}
}
