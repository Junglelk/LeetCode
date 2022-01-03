package normal.question_0338.CountingBits;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1
 * <p>
 * such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/5 22:04
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits(5)));

    }

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{};
        }
        if (n == 1) {
            return new int[]{1};
        }
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i - 1] + 1;
            }

        }
        return ans;
    }
}
