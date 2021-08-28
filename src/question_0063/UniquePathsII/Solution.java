package question_0063.UniquePathsII;

import org.junit.Test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 不同路径 I是用数学做的，这回得考虑真的用dp了...
 * <p>
 * <pre>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * </pre>
 * 来源：力扣（LeetCode）<br>
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii<br>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br>
 *
 * @author Jungle
 * @since 2021/8/28 20:46
 */
public class Solution {
    @Test
    public void test() {
//        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}, {0}}));
//        System.out.println(uniquePathsWithObstacles(new int[][]{
//                        {0, 0, 0, 0, 1, 0},
//                        {0, 0, 1, 0, 1, 0},
//                        {0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 1, 0},
//                        {0, 0, 0, 0, 0, 0},
//                        {0, 0, 1, 0, 0, 0},
//                        {0, 1, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 1, 0, 0},
//                }
//        ));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1) {
            return obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
        } else if (m == 1) {
            for (int i = 0; i < obstacleGrid[0].length; i++) {
                if (obstacleGrid[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }else if (n==1){
            for (int[] ints : obstacleGrid) {
                if (ints[0] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1 || (obstacleGrid[0][1] == 1 && obstacleGrid[1][0] == 1)) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                for (int j = i; j < n; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                for (int j = i; j < m; j++) {
                    dp[j][0] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (obstacleGrid[i][j] != 1 && dp[i - 1][j] != 0 && dp[i][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (obstacleGrid[i][j] != 1 && dp[i - 1][j] == 0 && dp[i][j - 1] != 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
