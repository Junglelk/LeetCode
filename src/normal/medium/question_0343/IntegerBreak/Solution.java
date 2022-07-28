package normal.medium.question_0343.IntegerBreak;

import org.junit.jupiter.api.Test;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * <pre>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * </pre>
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/integer-break">integer-break</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/16 22:51
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] ans = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            int cur = 0;
            for (int j = 0; j < i; j++) {
                cur = Math.max(Math.max(cur, j * (i - j)), j * ans[i - j]);
            }
            ans[i] = cur;
        }
        return ans[n];
    }
}
