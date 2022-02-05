package normal.easy.question_1342.NumberOfStepsToReduceANumberToZero;

import org.junit.jupiter.api.Test;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * <p>
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * <p>
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/01/31 18:05
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(numberOfSteps(14));
    }

    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0 && ++ans >= 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
        }
        return ans;
    }
}
