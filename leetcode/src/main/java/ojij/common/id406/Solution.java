package ojij.common.id406;

import java.util.Arrays;

/**
 * 先排序
 * 后从小到大按空位安排位置
 *
 * <ul>
 * <li>间复杂度: o(n^2)</li>
 * <li>空间复杂度: o(log n)</li>
 * </ul>
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> { // 从矮到高排序(登高按before从大到小)
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int[][] ans = new int[people.length][2];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < people.length; ++i) {
                if (ans[i][0] == 0) { // 该位置为空
                    --spaces;
                    if (spaces == 0) { // 插入该人
                        ans[i][0] = person[0];
                        ans[i][1] = person[1];
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
