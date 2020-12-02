package ojij.common.id164;

import java.util.Arrays;

/**
 * 题目要求是在线性时间、空间复杂度下完成，于是想到用线性复杂度的计数排序算法。
 * 同时还能在最后反向填充时顺带计数，一切都这么完美。。。
 * <p>
 * 结果失败了：测试用例[2,99999999]直接OOM，因为使用了99999998个大小的中间数组
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i] > max)
                max = nums[i];
        }
        int[] counting = new int[max - min + 1];
        if (counting.length == 1) { // 这里直接返回；后续无法处理全部相同的数的情况
            return 0;
        }
        // 计算次数
        for (int i = nums.length - 1; i >= 0; i--) {
            counting[nums[i] - min]++;
        }
        int zeroCount = 0;
        int maxZeroCount = 0;
        int increment = 0;
        for (int i = min; i <= max; i++) {
            if (counting[i - min] == 0) { // 该位置无值
                zeroCount++;
            } else { // 该位置有数值
                zeroCount++; // 还要再加一次
                if (zeroCount > maxZeroCount) {
                    maxZeroCount = zeroCount;
                }
                zeroCount = 0;
                for (int j = 0; j < counting[i - min]; j++) {
                    // in place, may not stable if you care
                    nums[increment++] = i;
                }
            }
        }
        return maxZeroCount;
    }

    public void countingSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        int min = array[0], max = array[0];
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < min)
                min = array[i];
            else if (array[i] > max)
                max = array[i];
        }
        int[] counting = new int[max - min + 1];
        // 计算次数
        for (int i = array.length - 1; i >= 0; i--) {
            counting[array[i] - min]++;
        }
        int increment = 0;
        for (int i = min; i <= max; i++) {
            for (int j = 0; j < counting[i - min]; j++) {
                // in place, may not stable if you care
                array[increment++] = i;
            }
        }
    }
}
