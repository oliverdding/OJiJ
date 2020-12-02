package ojij.common.id164;

import java.util.Arrays;

/**
 * 虽然{@code Solution3}总算是打卡完成，但是这不妥当。
 * 我并未实现线性时间复杂度内完成排序
 * 因此这里考虑使用最低优先位基数排序，并且在每次排序中使用计数排序
 */
public class Solution4 {
    public int maximumGap(int[] nums) {
        if (nums == null) {
            return 0;
        }
        radixSort(nums); // 同样先排序
        int max = 0;
        for (int i = nums.length - 1; i > 0; i--) { // 挨个找差值最大的
            if (nums[i] - nums[i - 1] > max)
                max = nums[i] - nums[i - 1];
        }
        return max;
    }

    public void radixSort(int[] array) {
        long exp = 1L;
        int[] buf = new int[array.length];
        int max = Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
        while (max >= exp) {
            int[] cnt = new int[10];
            for (int j : array) { // Counting
                cnt[(j / (int) exp) % 10]++;
            }
            for (int i = 1; i != 10; i++) { // 累加前者的次数
                cnt[i] += cnt[i - 1];
            }
            for (int i = array.length - 1; i >= 0; i--) { // 按照出现次数排序：反序保证顺序
                byte bit = (byte) ((array[i] / (int) exp) % 10);
                buf[--cnt[bit]] = array[i];
            }
            System.arraycopy(buf, 0, array, 0, array.length);
            exp *= 10L;
        }
    }
}
