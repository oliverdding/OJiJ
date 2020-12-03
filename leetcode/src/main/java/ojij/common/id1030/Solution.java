package ojij.common.id1030;

import java.util.Arrays;

/**
 * 直接创建二维数组，长度为单元格数目，存储每个下标
 * 利用sort方法直接对数组进行排序
 * <p>
 *
 * @author RikkiYang
 * @version 1.0.0
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] arr = new int[R * C][];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                arr[C * i + j] = new int[]{i, j};
            }
        Arrays.sort(arr, (e1, e2) -> (Math.abs(e1[0] - r0) + Math.abs(e1[1] - c0)) - (Math.abs(e2[0] - r0) + Math.abs(e2[1] - c0)));
        return arr;
    }
}
