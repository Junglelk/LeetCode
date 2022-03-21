package normal.easy.question_1523.CountOddNumbersInAnIntervalRange;

/**
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Jungle
 * @since 2022/3/21 22:01
 */
public class Solution {
    public int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public int pre(int x) {
        return (x + 1) >> 1;
    }
}
