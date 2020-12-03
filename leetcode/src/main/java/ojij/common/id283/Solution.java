package ojij.common.id283;


/**
 * 移动零问题：
 * 1.先找到第一个为零下标，用j标记
 * 2.从下标j开始遍历，有非零数据传递给nums[j]，再移动j的下标
 * 3.当i遍历完之后，说明j后面的数据全为零，进行赋值
 *
 * @author RikkiYY
 * @author OliverDD
 * @version 1.0.1
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int i, j = 0; // 设置两个遍历的下标，一个遍历，一个用于赋值
        while (j < nums.length && nums[j] != 0) { // 找到第一个为零的数并标记
            j++;
        }
        for (i = j; i < nums.length; i++) {
            if (nums[i] != 0) { // 将后续非零数据移动到前面
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) { // 将剩下的归零
            nums[j++] = 0;
        }
    }
}
