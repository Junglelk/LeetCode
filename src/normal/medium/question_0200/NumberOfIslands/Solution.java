package normal.medium.question_0200.NumberOfIslands;

import org.junit.jupiter.api.Test;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <pre>
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/2 16:47
 */
public class Solution {

    @Test
    public void test() {
//        System.out.println(numIslands(new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        }));
        System.out.println(numIslands(new char[][]{{'1', '1'}}));
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vistited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int[] dir : dirs) {
                    int newI = dir[0] + i;
                    int newJ = dir[1] + j;
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        if (grid[newI][newJ] == '1' && !vistited[newI][newJ]) {
                            temp++;
                        }
                    }
                }
                if (temp == 1 || temp == 0) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0';
                        vistited[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
