package question_0131.PalindromePartitioning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * <pre>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/9/6 23:13
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(partition("aabaa"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        String[][] dp = new String[s.length()][s.length()];
        dp[0][0] = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = dp[0][i - 1] + s.charAt(i);
        }
        List<String> temp = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

            }
        }

        ret.add(temp);
        return new ArrayList<>();
    }
}
