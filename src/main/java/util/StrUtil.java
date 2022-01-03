package util;

import java.util.List;

public class StrUtil {


    public static void toString(List<Integer>[][] x) {
        for (List<Integer>[] lists : x) {
            for (List<Integer> list : lists) {
                System.out.printf("%10s|", list == null ? "" : list.toString());
            }
            System.out.println();
        }
    }
}
