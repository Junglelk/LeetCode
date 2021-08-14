package question_Sword10_1.Fibonacci;

/**
 * 传统的斐波那契数列题
 *
 * @author Jungle
 * @since 2021/8/14 23:06
 */
public class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int first = 0;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            two = first + two;
            first = two - first;
            two = (two % 1000000007);
        }
        return two;
    }
}
