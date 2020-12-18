package ojij.common.id28;

/**
 * 子字符串匹配，使用KMP算法。
 * 其中，使用原始pmt而不是next、pre等等变体。
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] pmt = getPartialMatchTable(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j != 0 && haystack.charAt(i) != needle.charAt(j))
                j = pmt[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                ++j;
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public int[] getPartialMatchTable(String substr) {
        int[] pmt = new int[substr.length()]; // Partial Match Table
        pmt[0] = 0;
        int j = 0; // 最长前缀的长度
        for (int i = 1; i < substr.length(); ++i) { // 当前下标
            while (j != 0 && substr.charAt(i) != substr.charAt(j))
                j = pmt[j - 1];
            if (substr.charAt(i) == substr.charAt(j))
                ++j;
            pmt[i] = j;
        }
        return pmt;
    }

}
