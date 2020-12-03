package ojij.common.id976;

import java.util.Arrays;

/**
 * 刚刚题目都理解错了，因为已经排好序，要满足两边和大于第三边，那只能是i-2,i-1,i三个数判断。。。
 */
public class Solution2 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}

