package normal.medium.question_1020.NumberOfEnclaves;

import org.junit.jupiter.api.Test;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * <p>
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * <p>
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * <p>
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * <p>
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <pre>
 * 输入：grid = [
 *              [0,0,0,0],
 *              [1,0,1,0],
 *              [0,1,1,0],
 *              [0,0,0,0]
 *             ]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/4 23:22
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        }));
    }


    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(grid, i, j)) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean dfs(int[][] grid, int i, int j) {
        // 越界，说明遍历到了边界


        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length) {
                return false;
            }
            dfs(grid, ni, nj);
        }


        return true;
    }


}
