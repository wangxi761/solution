package topic.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SetMatrixZeroesTest {

    @Test
    public void setZeroes() {
//        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] arr = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(arr);
        Arrays.stream(arr)
              .map(Arrays::toString)
              .forEach(System.out::println);
    }
}

