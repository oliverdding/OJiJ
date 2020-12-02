package ojij.common.id164;

import java.util.Arrays;

/**
 * 问题明显出在排序算法上。
 * 计数排序不适合于差异大的数组，先考虑使用java库中的排序算法。
 * O(n log(n))
 */
public class Solution3 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = nums.length - 1; i != 0; i--) {
            if (nums[i] - nums[i - 1] > max) {
                max = nums[i] - nums[i - 1];
            }
        }
        return max;
    }
}
