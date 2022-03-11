package normal.medium.question_0695.MaxAreaOfIsland;

import org.junit.jupiter.api.Test;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <pre>
 * 输入：grid = [
 *              {0,0,1,0,0,0,0,1,0,0,0,0,0},
 *              {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *              {0,1,1,0,1,0,0,0,0,0,0,0,0},
 *              {0,1,0,0,1,1,0,0,1,0,1,0,0},
 *              {0,1,0,0,1,1,0,0,1,1,1,0,0},
 *              {0,0,0,0,0,0,0,0,0,0,1,0,0},
 *              {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *              {0,0,0,0,0,0,0,1,1,0,0,0,0}
 *            ]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/3 16:25
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, temp);
                }
            }
        }
        return Math.max(maxArea, 0);
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] grid, int i, int j) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            area += dfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}