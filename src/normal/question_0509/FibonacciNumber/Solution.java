package normal.question_0509.FibonacciNumber;

import org.junit.Test;

/**
 * 这两天比较忙，做占位，完成每日提交
 *
 * @author Jungle
 * @since 2021/7/12 22:20
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(fib(5));
    }


    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}