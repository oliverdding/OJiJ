package ojij.common.id767;


/**
 * 题目：重构字符串，使其两相邻的字符不同
 * 思路：字符范围为小写字母，构建一个数组num[26],用来存放字符
 * 若最大字符长度大于(s.length+1)/2，则输出“”
 * 将字符个数最多的先排列出来，剩下的不断插空即可
 *
 * @author RikkiYang
 * @version 1.0.0
 */

public class Solution {
    public String reorganizeString(String S) {
        int max = 0, n = S.length();
        int[] num = new int[26];
        int m = 0;//存放字符个数最多下标
        for (int i = 0; i < n; i++) {
            num[S.charAt(i) - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (max < num[j]) {
                max = num[j];
                m = j;
            }
        }
        if (max > (n + 1) / 2)
            return "";
        StringBuilder str = new StringBuilder();
        while (num[m] > 0) {
            str.append((char) (m + 'a'));
            num[m]--;
        }
        int position = 1;
        for (int k = 0; k < 26; k++) {
            while (num[k] > 0) {
                str.insert(position, (char) (k + 'a'));
                num[k]--;
                position += 2;
                if (position > str.length())
                    position = 1;
            }
        }
        return str.toString();
    }
}
