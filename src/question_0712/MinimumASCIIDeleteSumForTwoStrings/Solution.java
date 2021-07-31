package question_0712.MinimumASCIIDeleteSumForTwoStrings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
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
        List<Character> equal = new ArrayList<>();
        for (int i = 1; i <= s1.length(); i++) {
            int temp = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                int temp1 = s2.charAt(j - 1);
                if (temp1 == temp) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    equal.add((char)temp);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(equal);
        return dp[m][n];
    }
}
