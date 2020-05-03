package topic.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SortColorsTest {

    @Test
    public void sortColors() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}