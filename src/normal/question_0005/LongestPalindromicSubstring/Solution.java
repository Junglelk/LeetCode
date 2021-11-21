package normal.question_0005.LongestPalindromicSubstring;

/**
 * Given a string s, return the longest palindromic substring in s.
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/06 22:00
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // 最外层循环做假设：最长字串为K
        for (int K = 0; K < n; ++K) {
            for (int i = 0; i + K < n; ++i) {
                // 每次都以假设最长为K开始从头循环，结合外层K值防止数组越界
                int j = i + K;
                if (K == 0) {
                    //只有一个元素
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (K == 1) {
                        dp[i][j] = b;
                    } else {
                        //状态转移方程，只有当前两字母相等，且其内部序列也为回文时，对应位置的状态为true
                        dp[i][j] = (b && dp[i + 1][j - 1]);
                    }
                }
                if (dp[i][j] && K + 1 > ans.length()) {
                    ans = s.substring(i, i + K + 1);
                }
            }
        }
        return ans;
    }
}
