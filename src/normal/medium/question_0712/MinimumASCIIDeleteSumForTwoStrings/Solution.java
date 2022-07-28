package normal.medium.question_0712.MinimumASCIIDeleteSumForTwoStrings;

import org.junit.jupiter.api.Test;

/**
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * <p>我们用 <code>dp[i][j]</code> 表示字符串 <code>s1[i:]</code> 和 <code>s2[j:]</code>
 * （<code>s1[i:]</code> 表示字符串 <code>s1</code> 从第 i 位到末尾的子串，<code>s2[j:]</code> 表示字符串 <code>s2</code>
 * 从第 j 位到末尾的子串，字符串下标从 0 开始）达到相等所需删除的字符的 ASCII 值的最小和，最终的答案为 <code>dp[0][0]</code>。</p>
 *
 * <p>当 <code>s1[i:]</code> 和 <code>s2[j:]</code> 中的某一个字符串为空时，
 * <code>dp[i][j]</code> 的值即为另一个非空字符串的所有字符的 ASCII 值之和。
 * 例如当 <code>s2[j:]</code> 为空时，此时有 <code>j = s2.length()</code>，状态转移方程为</p>
 * <code>dp[i][j] = s1.asciiSumFromPos(i)</code>
 * <p>也可以写成递推的形式，即</p>
 * <pre><code>dp[i][j] = dp[i + 1][j] + s1.asciiAtPos(i)
 * </code></pre>
 * <p>对于其余的情况，即两个字符串都非空时，如果有 <code>s1[i] == s2[j]</code>，那么当前位置的两个字符相同，它们不需要被删除，状态转移方程为</p>
 * <pre><code>dp[i][j] = dp[i + 1][j + 1]
 * </code></pre>
 * <p>如果 <code>s1[i] != s2[j]</code>，那么我们至少要删除 <code>s1[i]</code> 和 <code>s2[j]</code> 两个字符中的一个，因此状态转移方程为</p>
 * <pre><code>dp[i][j] = min(dp[i + 1][j] + s1.asciiAtPos(i), dp[i][j + 1] + s2.asciiAtPos(j))
 * </code></pre>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings">minimum-ascii-delete-sum-for-two-strings</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/31 15:22
 */
public class Solution {
    @Test
    public void test() {
        // 231
//        System.out.println(minimumDeleteSum("sea", "eat"));
        // 403
        System.out.println(minimumDeleteSum("delete", "leet"));

    }


    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.codePointAt(i);
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j + 1] + s2.codePointAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i), dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }
        return dp[0][0];
    }
}
