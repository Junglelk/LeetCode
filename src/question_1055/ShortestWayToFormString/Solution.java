package question_1055.ShortestWayToFormString;

import org.junit.Test;

/**
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.
 * <p>
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
 * <p>
 * 给定源字符串 source 和目标字符串 target，
 * 找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 * <p>
 * <pre>
 * 输入：source = "abc", target = "abcbc"
 * 输出：2
 * 解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
 * </pre>
 * <pre>
 * 输入：source = "xyz", target = "xzyxz"
 * 输出：3
 * 解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-way-to-form-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/21 21:24
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(shortestWay("", ""));
    }

    /**
     * 每次都将源字符串延长，知道两者相同子串与target一致，记录延长次数。但会超时...
     *
     * @param source
     * @param target
     * @return
     */
    public int shortestWay(String source, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (-1 == source.indexOf(target.charAt(i))) {
                return -1;
            }
        }
        int times = 0;
        int length = 0;
        StringBuilder temp = new StringBuilder();
        while (length != target.length()) {
            times++;
            temp.append(source);
            length = longestCommonSubsequence(temp.toString(), target);
        }

        return times;
    }

    /**
     * 最长公共子序列
     *
     * @param text1 源字符串
     * @param text2 目标字符串
     * @return 公共子序列长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char temp = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char temp1 = text2.charAt(j - 1);
                if (temp == temp1) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
