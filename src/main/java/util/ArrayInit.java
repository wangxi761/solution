package util;

public class ArrayInit {
    public static void main(String[] args) {
        String origin = "[[1,2],[2,3],[3,4],[4,5]]";
        System.out.println(origin.replace("[","{").replace("]","}"));
    }
}
