package normal.medium.question_1905.CountSubIslands;

import org.junit.jupiter.api.Test;

/**
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 * <p>
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 * <p>
 * Return the number of islands in grid2 that are considered sub-islands.
 * <p>
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * <p>
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * <p>
 * 请你返回 grid2 中 子岛屿 的 数目 。
 * <pre>
 * 输入：grid1 = [
 *              [1,1,1,0,0],
 *              [0,1,1,1,1],
 *              [0,0,0,0,0],
 *              [1,0,0,0,0],
 *              [1,1,0,1,1]
 *             ]
 *    grid2 = [
 *              [1,1,1,0,0],
 *              [0,0,1,1,1],
 *              [0,1,0,0,0],
 *              [1,0,1,1,0],
 *              [0,1,0,1,0]
 *            ]
 * 输出：3
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sub-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/6 23:04
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(countSubIslands(new int[][]{
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        }, new int[][]{
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        }));
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i >= grid1.length || i < 0 || j >= grid1[0].length || j < 0 || grid2[i][j] != 1) {
            // 这里该return的是true才对
            return true;
        }
        grid2[i][j] = 0;
        boolean temp = grid1[i][j] == 1;
        for (int[] dir : dirs) {
            temp &= dfs(grid1, grid2, i + dir[0], j + dir[1]);
        }
        return temp;
    }
}
