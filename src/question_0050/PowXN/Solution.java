package question_0050.PowXN;

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
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}
