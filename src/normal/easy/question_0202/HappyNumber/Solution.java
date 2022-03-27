package normal.easy.question_0202.HappyNumber;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * <li/>Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * <li/>Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * <li/>Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/27 23:00
 */
public class Solution {
    public boolean isHappy(int n) {
        int ret = 0;
        while (n > 4) {
            int temp = n % 10;
            ret += temp * temp;
            n /= 10;
            if (n < 10) {
                n = ret + (n * n);
                ret = 0;
            }
        }
        return n == 1;
    }
}
