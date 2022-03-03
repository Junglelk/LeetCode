package normal.medium.question_1254.NumberOfClosedIslands;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <pre>
 * 输入：grid = [
 *              [1,1,1,1,1,1,1,0],
 *              [1,0,0,0,0,1,1,0],
 *              [1,0,1,0,1,1,1,0],
 *              [1,0,0,0,0,1,0,1],
 *              [1,1,1,1,1,1,1,0]
 *            ]
 * 输出：2
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/3 16:53
 */
public class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
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
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }
        grid[i][j] = 1;
        for (int[] dir : dirs) {

        }
        return area;
    }
}