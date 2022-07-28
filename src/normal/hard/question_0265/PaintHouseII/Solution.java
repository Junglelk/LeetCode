package normal.hard.question_0265.PaintHouseII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 来源：力扣（LeetCode）<br>
 * 链接：<a href="https://leetcode-cn.com/problems/paint-house-ii">paint-house-ii</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/19 9:53
 */
public class Solution {

    @Test
    public void test(){
        // [1,5,3,7],[2,9,4,6],[9,7,1,4],[12,11,8,7]
        System.out.println(minCostII(new int[][]{
                {1,5,3,7},
                {2,9,4,6},
                {9,7,1,4},
                {12,11,8,7},
        }));
    }

    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        for (int n = costs.length - 2; n >= 0; n--) {
            for (int k = 0; k < costs[n].length; k++) {
                int[] cur = costs[n + 1].clone();
                cur[k] = -1;
                Arrays.sort(cur);
                costs[n][k] += cur[1];
            }
        }
        int[] result = costs[0].clone();
        Arrays.sort(result);
        return result[0];
    }
}
