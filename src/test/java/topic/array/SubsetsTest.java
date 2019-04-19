package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubsetsTest {

    @Test
    public void subsets() {
        int[] arr = {1, 2, 3};
        Subsets subsets = new Subsets();
        subsets.subsets(arr)
               .stream()
               .forEach(i -> System.out.println(i));
    }
}