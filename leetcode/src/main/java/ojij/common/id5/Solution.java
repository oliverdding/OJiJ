package ojij.common.id5;

/**
 * 题目为找到字符串中最长的回文子串
 * 下面为动态规划解法
 * 判断i到j是回文子串的条件为：s[i]==s[j]且i+1到j-1也是回文序列
 * 这里要注意要保证j-1>=i+1,即j>=i+2,当i+1=j时，字串只有两个字符，这时判断s[i]==s[j]即可，i=j时，字符串有一个字符，也是回文子串。
 *
 * @author RikkiYang
 * @version 1.0.0
 */

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), i, j, l = 0;
        boolean[][] dp = new boolean[n][n];
        String subs = "";
        for (; l < n; l++) {
            for (i = 0; i < n - l; i++) {
                j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && l + 1 > subs.length()) {
                    subs = s.substring(i, i + l + 1);
                }
            }
        }
        return subs;
    }
}
