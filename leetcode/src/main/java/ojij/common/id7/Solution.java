package ojij.common.id7;

public class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        if (isNeg) {
            x = -x;
        }
        int result = 0;
        while (x > 0) {
            long temp = (long) result * 10;
            if ((int) temp != temp) {
                return 0;
            }
            result = (int) temp + x % 10;
            x /= 10;
        }
        if (isNeg)
            result = -result;
        return result;
    }

    int add(int x, int y) {
        int result = x + y;
        if (((x ^ result) & (y ^ result)) < 0) {
            return -1;
        }
        return result;
    }
}