package ojij.common.id670;

import java.util.Arrays;

/**
 * 思路是：
 * 将数字逐位拆解后从大到小排序，确保排序后一一对应，否则交换一位即可
 *
 * @author OliverDDD
 * @version 1.0.0
 */
public class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        char[] numsOrig = nums.clone();
        int n = nums.length - 1;
        Arrays.sort(nums);
        for (int i = n; i >= 0; i--) {
            if (nums[i] != numsOrig[n - i]) { // 找不相同的最高位
                // 在numsOrig中交换最右边numsOrig[i]这个数的位和nums[i]这个数的位
                for (int j = n; j > n - i; j--) {
                    if (numsOrig[j] == nums[i]) { // 找到最左边numsOrig[i]这个数的下标j
                        numsOrig[j] = (char) ((int) (numsOrig[n - i] = (char) ((int) (numsOrig[j] = (char) ((int) numsOrig[n - i] ^ (int) numsOrig[j])) ^ (int) numsOrig[n - i])) ^ (int) numsOrig[j]);
                        break;
                    }
                }
                break;
            }
        }
        return Integer.parseInt(String.valueOf(numsOrig));
    }
}
