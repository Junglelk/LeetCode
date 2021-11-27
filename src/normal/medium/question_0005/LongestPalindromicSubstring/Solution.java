package normal.medium.question_0005.LongestPalindromicSubstring;

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
        // top为最长回文串的长度,由于下标从 0 开始，所以top从 0 开始意为单个字母
        for (int top = 0; top < n; top++) {
            for (int i = 0; i + top < n; i++) {
                int j = i + top;
                if (top == 0) {
                    dp[i][j] = true;
                } else {
                    boolean temp = s.charAt(i) == s.charAt(j);
                    if (top == 1) {
                        dp[i][j] = temp;
                    } else {
                        dp[i][j] = temp && dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && top + 1 > ans.length()) {
                    ans = s.substring(i, i + top + 1);
                }
            }
        }
        return ans;
    }
}
