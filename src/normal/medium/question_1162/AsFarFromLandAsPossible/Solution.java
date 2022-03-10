package normal.medium.question_1162.AsFarFromLandAsPossible;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
 * <p>
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * <p>
 * 你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。
 * <p>
 * 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回 -1。
 * <p>
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <pre>
 * 输入：grid = [
 *              [1,0,0],
 *              [0,0,0],
 *              [0,0,0]
 *            ]
 * 输出：4
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/7 9:48
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(maxDistance(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
    }


    /**
     * 广度优先遍历解决两个问题：<br>
     * 1. 一个点能否到另一个点<br>
     * 2. 两点间的最短距离
     *
     * @param grid 地形数组
     * @return 最大长度
     */
    public int maxDistance(int[][] grid) {
        int ans = -1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, findNearestLand(grid, i, j));
                }
            }
        }
        return ans;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int findNearestLand(int[][] grid, int i, int j) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int nI = dir[0] + poll[0];
                int nJ = dir[1] + poll[1];
                if (nI < 0 || nI >= grid.length || nJ < 0 || nJ >= grid.length) {
                    continue;
                }
                // 没有遍历过，则遍历该节点
                if (!visited[nI][nJ]) {
                    queue.offer(new int[]{nI, nJ, poll[2] + 1});
                    visited[nI][nJ] = true;
                    if (grid[nI][nJ] == 1) {
                        return poll[2] + 1;
                    }
                }
            }
        }
        return -1;
    }


}
