package ojij.common.id4;

/**
 * 首先直接暴力，考虑o(m+n)的暴力求解，直接合并两个数组，犹如分治算法的merge那步
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1 == null ? 0 : nums1.length;
        int n = nums2 == null ? 0 : nums2.length;
        int[] temp = new int[m + n];
        int lptr = 0, rptr = 0;
        int ptr = 0;
        while (lptr < m || rptr < n) {
            while (lptr < m && (rptr >= n || nums1[lptr] <= nums2[rptr])) {
                temp[ptr++] = nums1[lptr++];
            }
            while (rptr < n && (lptr >= m || nums1[lptr] >= nums2[rptr])) {
                temp[ptr++] = nums2[rptr++];
            }
        }
        if (((m + n) & 1) == 1) {
            return temp[(m + n) / 2] * 1.0;
        } else {
            return (1.0 * temp[(m + n) / 2] + 1.0 * temp[(m + n) / 2 - 1]) / 2.0;
        }
    }
}
