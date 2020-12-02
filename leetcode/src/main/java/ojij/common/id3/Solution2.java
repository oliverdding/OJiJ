package ojij.common.id3;


/**
 * 该解答采取中心扩散的方法
 * 以每一个字符为中心向外扩散，比较找出最长字符串
 *
 * @author RikkiYang
 * @version 1.0.0
 */

public class Solution2 {
    public String longestPalindrome(String s) {
        int len, len1, len2, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            len1 = extendString(s, i, i);
            len2 = extendString(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int extendString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
