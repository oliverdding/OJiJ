package ojij.common.id34;

/**
 * 给你个升序数组+target找到第一个位置和最后一个位置。
 * 这，，，这不就是二分吗二分二分，二分真的非常精髓
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    /**
     * @param nums   待搜索的非递减数组
     * @param target 目标值
     * @return 起始下标个终点下标组成的二元数组
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int index = binarySearch(nums, target, 0, nums.length - 1);
        if (index == -1)
            return new int[]{-1, -1};
        int bidx = index - 1;
        while (bidx >= 0 && nums[bidx] == target) {
            bidx--;
        }
        int eidx = index + 1;
        while (eidx < nums.length && nums[eidx] == target) {
            eidx++;
        }
        return new int[]{bidx == -1 ? 0 : bidx + 1, eidx == nums.length ? nums.length - 1 : eidx - 1};
    }

    /**
     * 二分法从给定数组中找到target的下标
     *
     * @param nums   待搜寻数组
     * @param target 待搜寻的值
     * @param low    待搜寻头下标
     * @param high   待搜寻尾下标
     * @return target在nums中的下标。若不存在则为-1
     */
    public int binarySearch(int[] nums, int target, int low, int high) {
        if (low == high && nums[low] != target)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid);
        } else {
            return binarySearch(nums, target, mid + 1, high);
        }
    }
}
