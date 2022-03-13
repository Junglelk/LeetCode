package normal.medium.question_0417.PacificAtlanticWaterFlow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * <p>
 * 有一个 m × n 的长方形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个个方格网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻小区的高度 小于或等于 当前小区的高度，雨水可以直接向北、南、东、西流向相邻小区。水可以从海洋附近的任何细胞流入海洋。
 * <p>
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 * <pre>
 * 输入: heights = [
 *                  [1,2,2,3,5],
 *                  [3,2,3,4,4],
 *                  [2,4,5,3,1],
 *                  [6,7,1,4,5],
 *                  [5,1,1,2,4]
 *                ]
 * 输出: [
 *          [0,4],
 *          [1,3],
 *          [1,4],
 *          [2,2],
 *          [3,0],
 *          [3,1],
 *          [4,0]
 *     ]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/7 22:00
 */
public class Solution {

    @Test
    public void test() {
        // TODO
        System.out.println(pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }


    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(heights, visited, ans, temp, 0, 0);
        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, List<List<Integer>> ans, List<Integer> temp, int i, int j) {
        if ((visited[0][j] || visited[i][0]) && (visited[i][heights[i].length - 1] || visited[heights.length - 1][j])) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int m = i; m < heights.length; m++) {
            for (int n = j; n < heights[0].length; n++) {
                if (visited[m][n]) {
                    continue;
                }
                if (i == 2 && j == 2) {
                    System.out.println("case");
                }
                visited[m][n] = true;
                temp.add(m);
                temp.add(n);
                for (int[] dir : dirs) {
                    int newI = m + dir[0];
                    int newJ = n + dir[1];
                    if (newI >= heights.length || newI < 0 || newJ >= heights[0].length || newJ < 0) {
                        continue;
                    }
                    if (!visited[newI][newJ] && heights[newI][newJ] <= heights[m][n]) {
                        dfs(heights, visited, ans, temp, newI, newJ);
                    }
                }
                visited[m][n] = false;
                temp.remove(temp.size() - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
