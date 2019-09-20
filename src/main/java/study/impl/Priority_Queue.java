package study.impl;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Priority_Queue {
	@Test
	public void test() throws NoSuchFieldException, IllegalAccessException {
		List list = new ArrayList();
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.trySetAccessible();
		int last = 0;
		for (int i = 0; i < 100; i++) {
			list.add(i);
			Object[] elementData = (Object[]) field.get(list);
			if (elementData.length != last) {
				System.out.println(String.format("%d\t%d\t%d", elementData.length, i, i + (i >> 1)));
				last = elementData.length;
			}
		}
	}
	
}
