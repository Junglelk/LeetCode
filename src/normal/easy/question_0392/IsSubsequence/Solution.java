package normal.easy.question_0392.IsSubsequence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * </p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/is-subsequence">is-subsequence</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/6 11:43
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(isSubsequence("", "abcde"));
    }

    public boolean isSubsequence(String s, String t) {
        if ("".equals(s)){
            return true;
        }
        if (t.length() <= s.length()) {
            return s.equals(t);
        }
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j == s.length()) {
                break;
            }
            if (t.charAt(i) == s.charAt(j)) {
                dp[j] = true;
                j++;
            }
        }
        return dp[s.length()-1];
    }
}
