package topic.sort;

import org.junit.jupiter.api.Test;
import util.ArrayUtil;

public class MatrixCellsinDistanceOrderTest {
	MatrixCellsinDistanceOrder test = new MatrixCellsinDistanceOrder();
	
	@Test
	public void allCellsDistOrder() {
		ArrayUtil.prettyPrint(test.allCellsDistOrder(2, 2, 0, 1));
	}
}