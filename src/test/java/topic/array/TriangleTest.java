package topic.array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TriangleTest {

	@Test
	public void testMinimumTotal() {
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list.add(Arrays.asList(2));
		list.add(Arrays.asList(3,4));
		list.add(Arrays.asList(5,6,7));
		list.add(Arrays.asList(4,1,8,3));
		Triangle triangle=new Triangle();
		assertEquals(11, triangle.minimumTotal(list));
	}

}
