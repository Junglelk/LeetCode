package normal.medium.question_1091.ShortestPathInBinaryMatrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * <li>All the visited cells of the path are 0.
 * <li>All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * <p>
 * The length of a clear path is the number of visited cells of this path.
 * <p>
 * <p>
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * <li>路径途经的所有单元格都的值都是 0 。
 * <li>路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * <p>
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <pre>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/11 13:36
 */
public class Solution {

    @Test
    public void test() {
        // [0,0,0],[1,1,0],[1,1,0]
        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    int[][] dirs = new int[][]{{1, -1}, {1, 1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        bfs(grid, visited, queue);
        if (visited[n - 1][n - 1]) {
            return queue.size();
        }
        return -1;
    }

    private void bfs(int[][] grid, boolean[][] visited, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int ni = dir[0] + poll[0];
                int nj = dir[1] + poll[1];
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid.length) {
                    visited[ni][nj] = true;
                    if (grid[ni][nj] == 0 ) {
                        queue.offer(new int[]{ni, nj});
                    }
                }
                if (visited[grid.length - 1][grid.length - 1]) {
                    return;
                }
            }
        }
    }
}
