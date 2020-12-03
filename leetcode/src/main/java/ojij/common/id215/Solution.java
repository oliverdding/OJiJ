package ojij.common.id215;

/**
 * Top-K问题，首先想到快速选择；
 * 然后想到堆排序。
 *
 * <p>这里考虑使用小根堆，在内存中维护k个大小的小根堆，
 * 插入新元素时，比根小则丢弃，因为肯定比第k个数小；
 * 比根大则替换根，因为此时的根肯定比第k个数小；
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        heapify(nums, k);
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > nums[0]) {
                nums[0] = (nums[i] = (nums[0] = nums[i] ^ nums[0]) ^ nums[i]) ^ nums[0];
                heapify(nums, k);
            }
        }
        return nums[0];
    }

    /**
     * 将nums[0..length)的内容小根堆化
     *
     * @param nums   小根堆原始数组
     * @param length 小根堆长度
     */
    private void heapify(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; --i) {
            if (2 * i + 2 < length) { // 有两个叶子
                int smaller = nums[2 * i + 1] < nums[2 * i + 2] ? 2 * i + 1 : 2 * i + 2;
                if (nums[i] > nums[smaller]) {
                    nums[i] = (nums[smaller] = (nums[i] = nums[smaller] ^ nums[i]) ^ nums[smaller]) ^ nums[i];
                }
            } else {
                if (nums[i] > nums[2 * i + 1]) {
                    nums[i] = (nums[2 * i + 1] = (nums[i] = nums[2 * i + 1] ^ nums[i]) ^ nums[2 * i + 1]) ^ nums[i];
                }
            }
        }
    }

}
