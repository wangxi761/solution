package bit;

import java.util.Arrays;

public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int next = encoded[i] ^ arr[i];
            arr[i + 1] = next;
        }
        return arr;
    }

    public static void main(String[] args) {
        DecodeXORedArray obj=new DecodeXORedArray();
        System.out.println(Arrays.toString(obj.decode(new int[]{1, 2, 3}, 1)));
    }
}
