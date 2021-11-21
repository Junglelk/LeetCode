package normal.question_0746.MinCostClimbingStairs;

/**
 * Description:
 * <p>
 * You are given an integer array cost where cost[i] is the cost of i th step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/15 17:36
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int first = 0;
        int next = 0;
        for (int i = 2; i <= cost.length; i++) {
            int temp = Math.min(next + cost[i - 1], first + cost[i - 2]);
            first = next;
            next = temp;
        }
        return next;
    }
}
