package normal.medium.question_1034.ColoringABorder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.
 * <p>
 * Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.
 * <p>
 * The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 * <p>
 * You should color the border of the connected component that contains the square grid[row][col] with color.
 * <p>
 * Return the final grid.
 * <p>
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 * <pre>
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * </pre>
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * <pre>
 * 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * </pre>
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coloring-a-border
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/7 21:11
 */
public class Solution {
    /**
     * 构造 ans 矩阵作为答案，同时 ans 也作为判重数组使用（通过判断 ans[i][j] 是否为 0 来得知是否被处理）；
     * <p>
     * 起始时，将 (row, col)位置进行入队，每次从队列中取出元素进行「四联通拓展」：
     * <p>
     * 拓展格子必须与起点格子处于同一「连通分量」，即满足两者起始颜色相同；
     * <p>
     * 进行「四联通拓展」的同时，记录当前出队是否为边界格子。若为边界格子，则使用 color 进行上色；
     * <p>
     * 跑完 BFS 后，对 ans 进行遍历，将未上色（ans[i][j] = 0）的位置使用原始色（grid[i][j]）进行上色。
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/coloring-a-border/solution/gong-shui-san-xie-tu-lun-sou-suo-zhuan-t-snvw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param grid  原始数组
     * @param row   横坐标
     * @param col   纵坐标
     * @param color 颜色编号
     * @return 结果
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 入队坐标
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{row, col});
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            // 获取坐标值
            int x = poll[0];
            int y = poll[1];
            int cnt = 0;
            // 遍历此坐标的上下左右
            for (int[] di : dirs) {
                int nx = x + di[0];
                int ny = y + di[1];
                // 过滤掉不合法的坐标
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 如果坐标处的颜色与其上/下/左/右不一致，换一个方向
                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                } else {
                    // 否则颜色数+1
                    cnt++;
                }
                // 此坐标被遍历过的处理方式
                if (ans[nx][ny] != 0) {
                    continue;
                }
                // 添加当前上/下/左/右的坐标为下一次遍历的中心
                d.addLast(new int[]{nx, ny});
            }
            // 如果当前坐标的上下左右都是一样的颜色，说明不需要染色；否则染成目标颜色
            ans[x][y] = cnt == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }
}
