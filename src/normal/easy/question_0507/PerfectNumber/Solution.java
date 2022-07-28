package normal.easy.question_0507.PerfectNumber;

import org.junit.jupiter.api.Test;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/perfect-number">perfect-number</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/6/20 22:12
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(checkPerfectNumber(28));
    }

    public boolean checkPerfectNumber(int num) {
        int half = num / 2;
        int sum = 0;
        for (int i = 1; i <= half; i++) {
            if ((num % i) == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}