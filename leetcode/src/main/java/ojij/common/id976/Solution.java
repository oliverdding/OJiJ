package ojij.common.id976;

import java.util.Arrays;

/**
 * 因为是简单题目，首先我想先用暴力尝试
 * <p>
 * 最终证明超时....
 * <p>
 * 得，简单题超时还是大姑娘上轿---头一遭
 */
public class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int edge1 = A.length - 1; edge1 >= 0; edge1--) {
            for (int edge2 = edge1 - 1; edge2 >= 0; edge2--) {
                int edge3 = edge2 - 1;
                while (edge3 >= 0 && (A[edge3] >= A[edge1] + A[edge2] || A[edge3] <=
                        Math.max(A[edge1], A[edge2]) - Math.min(A[edge1], A[edge2]))) {
                    edge3--;
                }
                if (edge3 >= 0) {
                    return A[edge1] + A[edge2] + A[edge3];
                }
            }
        }
        return 0;
    }
}
