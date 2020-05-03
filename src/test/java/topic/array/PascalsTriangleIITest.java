package topic.array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PascalsTriangleIITest {

	@Test
	public void testGetRow() {
		PascalsTriangleII pascalsTriangleII=new PascalsTriangleII();
		List<Integer> row = pascalsTriangleII.getRow(3);
		System.out.println(row);
	}

}
