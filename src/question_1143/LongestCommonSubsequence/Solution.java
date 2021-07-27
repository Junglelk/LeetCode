package question_1143.LongestCommonSubsequence;

/**
 * Description:
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。<br>
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。<br>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/27 17:21
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String small;
        String big;
        if (text1.length() > text2.length()) {
            big = text1;
            small = text2;
        } else {
            big = text2;
            small = text1;
        }
        int[][] dp = new int[small.length()][1];
        // dp[i][1] 表示 到第 i 个元素时，最长子序列的长度。
        return 0;
    }
}
