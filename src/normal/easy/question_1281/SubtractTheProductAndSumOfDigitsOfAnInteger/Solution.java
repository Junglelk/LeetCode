package normal.easy.question_1281.SubtractTheProductAndSumOfDigitsOfAnInteger;

/**
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/22 23:06
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;
        while (n > 0) {
            int i = n % 10;
            sum += i;
            mul *= i;
            n /= 10;
        }
        return mul - sum;
    }
}
