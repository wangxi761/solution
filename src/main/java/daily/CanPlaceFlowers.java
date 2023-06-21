package daily;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean prev = i - 1 < 0 || flowerbed[i - 1] == 0;
            boolean cur = flowerbed[i] == 0;
            boolean next = i + 1 >= flowerbed.length || flowerbed[i + 1] == 0;
            if (prev && cur && next) {
                if (--n == 0) {
                    return true;
                }
                i++;
            } else if (!next) {
                i += 2;
            } else if (!cur) {
                i += 1;
            }
        }
        return false;
    }

}
