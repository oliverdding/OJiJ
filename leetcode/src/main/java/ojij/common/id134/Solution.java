package ojij.common.id134;

/**
 * 加油站问题：
 * 1.计算各个节点对油量的影响是正增长还是负增长
 * 2.遍历找出节点
 *
 * @author RikkiYY
 * @version 1.0.0
 */


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] temp = new int[gas.length];//存储两个数组的差值
        int sum, result = -1, i, j, k;
        for (k = 0; k < temp.length; k++) {
            temp[k] = gas[k] - cost[k];
        }
        for (i = 0; i < temp.length; i++) {
            if (temp[i] >= 0) {
                sum = 0;
                for (j = 0; j < temp.length; j++) {
                    sum += temp[(i + j) % temp.length];
                    if (sum < 0)
                        break;
                }
                if (j == temp.length)
                    result = i;
            }
        }
        return result;
    }
}
