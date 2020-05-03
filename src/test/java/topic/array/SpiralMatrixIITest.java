package topic.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SpiralMatrixIITest {

    @Test
    public void generateMatrix() {
        SpiralMatrixII spiralMatrixII=new SpiralMatrixII();
        Arrays.stream(spiralMatrixII.generateMatrix(3)).forEach(i-> System.out.println(Arrays.toString(i)));
    }
}