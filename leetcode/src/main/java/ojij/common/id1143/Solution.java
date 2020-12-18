package ojij.common.id1143;

/**
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0)
            return 0;
        // dp[i][j]表示text1[0..i]与text2[0..j]的LCS的长度为dp[i][j]
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        // Base case: [0][*], [*][0] = 0
        for (int i = 1; i <= text1.length(); ++i) {
            for (int j = 1; j <= text2.length(); ++j) {
                // 状态转移为：
                // 1. text1[i] == text2[j]: dp[i][j] = dp[i-1][j-1] + 1
                // 2. text1[i] != text2[j]: max(dp[i - 1][j], dp[i][j-1])
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
