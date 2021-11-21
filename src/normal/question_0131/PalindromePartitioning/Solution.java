package normal.question_0131.PalindromePartitioning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(partitionAnswer("aabaa"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        String[][] dp = new String[s.length()][s.length()];
        dp[0][0] = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = dp[0][i - 1] + s.charAt(i);
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = s.charAt(i) + "";
                } else {
                    dp[i][j] = dp[i][j - 1] + s.charAt(j);
                }
            }
        }
        int times = 0;
        while (times < s.length()) {
            int k = times;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = k; j < s.length(); ) {
                    if (isPalindrome(dp[i][j])) {
                        list.add(dp[i][j]);
                        i += dp[i][j].length();
                        j = i;
                    } else {
                        j++;
                    }
                }
            }
            ret.add(list);
            times++;
        }
        return ret;
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int j = str.length() - 1;
        int i = 0;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partitionAnswer(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
