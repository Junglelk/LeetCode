package question_0256.PaintHouse;

import org.junit.Test;

/**
 * There is a row of n houses, where each house can be painted one of three colors:
 * red, blue, or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 * <p>
 * For example, costs[0][0] is the cost of painting house 0 with the color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 * <p>
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 注意：
 * <p>
 * 所有花费均为正整数。
 * <p>
 * <pre>
 * 输入: [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/17 15:56
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(minCost(new int[][]{
                {17,2,17},
                {16,16,5},
                {14,3,19}
        }));
    }


    public int minCost(int[][] costs) {
        if (costs.length==0) return 0;

        for (int n = costs.length - 2; n >= 0; n--) {
            // 动态规划的表上作业，实在是太生疏了
            costs[n][0] += Math.min(costs[n+1][1], costs[n+1][2]);
            costs[n][1] += Math.min(costs[n+1][0], costs[n+1][2]);
            costs[n][2] += Math.min(costs[n+1][0], costs[n+1][1]);
        }

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}
