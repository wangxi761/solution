package topic.array;

public class SortColors {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    r++;
                    break;
                case 1:
                    w++;
                    break;
                case 2:
                    b++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i >= 0 && i < r)
                nums[i] = 0;
            else if (i >= r && i < r + w)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}
