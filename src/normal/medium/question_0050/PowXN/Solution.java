package normal.medium.question_0050.PowXN;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * </p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）
 * <pre>
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/28 20:27
 */
public class Solution {

    @Test
    public void test() {
        // 2.00000
        //-2147483648
        System.out.println(myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / pow(x, Math.abs((long) n));
        }
        return pow(x, n);
    }

    /**
     * @param x 原数字
     * @param n 幂数，测试用例有超过整形长度的值
     * @return 结果
     */
    public double pow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = pow(x, n / 2);
        if (n % 2 != 0) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}
