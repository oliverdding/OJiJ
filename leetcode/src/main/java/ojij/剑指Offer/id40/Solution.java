package ojij.剑指Offer.id40;

/**
 * 快速选择算法:
 *
 * @author OliverDD
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (k == arr.length) {
            return arr;
        }
        int[] result = new int[k];
        int low = 0, high = arr.length - 1;
        while (true) {
            int mid = fastSelect(arr, low, high);
            if (mid < k) { // select in [mid+1, high]
                low = mid + 1;
            } else if (mid > k) { // select in [low, mid-1]
                high = mid - 1;
            } else { // return [0..k]
                System.arraycopy(arr, 0, result, 0, k);
                return result;
            }
        }
    }

    /**
     * 从arr中快速选择一轮，返回目标中值下标
     *
     * @param arr  待排数组
     * @param low  起始下标
     * @param high 末尾下标
     * @return 中值下标
     */
    public int fastSelect(int[] arr, int low, int high) {
        int backup = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= backup)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= backup)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = backup;
        return low;
    }

}
