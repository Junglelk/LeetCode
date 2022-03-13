package competition.medium.competition_5203.CountArtifactsThatCanBeExtracted;

import org.junit.jupiter.api.Test;

/**
 * There is an n x n 0-indexed grid with some artifacts buried in it. You are given the integer n and a 0-indexed 2D integer array artifacts describing the positions of the rectangular artifacts where artifacts[i] = [r1i, c1i, r2i, c2i] denotes that the ith artifact is buried in the subgrid where:
 * <p>
 * <li/>(r1i, c1i) is the coordinate of the top-left cell of the ith artifact and
 * <li/>(r2i, c2i) is the coordinate of the bottom-right cell of the ith artifact.
 * You will excavate some cells of the grid and remove all the mud from them. If the cell has a part of an artifact buried underneath, it will be uncovered. If all the parts of an artifact are uncovered, you can extract it.
 * <p>
 * Given a 0-indexed 2D integer array dig where dig[i] = [ri, ci] indicates that you will excavate the cell (ri, ci), return the number of artifacts that you can extract.
 * <p>
 * The test cases are generated such that:
 * <p>
 * <li/>No two artifacts overlap.
 * <li/>Each artifact only covers at most 4 cells.
 * <li/>The entries of dig are unique.
 * <p>
 * 存在一个 n x n 大小、下标从 0 开始的网格，网格中埋着一些工件。给你一个整数 n 和一个下标从 0 开始的二维整数数组 artifacts ，artifacts 描述了矩形工件的位置，其中 artifacts[i] = [r1i, c1i, r2i, c2i] 表示第 i 个工件在子网格中的填埋情况：
 * <p>
 * <li/>(r1i, c1i) 是第 i 个工件 左上 单元格的坐标，且
 * <li/>(r2i, c2i) 是第 i 个工件 右下 单元格的坐标。
 * 你将会挖掘网格中的一些单元格，并清除其中的填埋物。如果单元格中埋着工件的一部分，那么该工件这一部分将会裸露出来。如果一个工件的所有部分都都裸露出来，你就可以提取该工件。
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 dig ，其中 dig[i] = [ri, ci] 表示你将会挖掘单元格 (ri, ci) ，返回你可以提取的工件数目。
 * <p>
 * 生成的测试用例满足：
 * <p>
 * <li/>不存在重叠的两个工件。
 * <li/>每个工件最多只覆盖 4 个单元格。
 * <li/>dig 中的元素互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-artifacts-that-can-be-extracted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/13 21:21
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(digArtifacts(6,
                new int[][]
                        {
                                {0, 2, 0, 5},
                                {0, 1, 1, 1},
                                {3, 0, 3, 3},
                                {4, 4, 4, 4},
                                {2, 1, 2, 4}
                        },
                new int[][]{
                        {0, 2},
                        {0, 3},
                        {0, 4},
                        {2, 0},
                        {2, 1},
                        {2, 2},
                        {2, 5},
                        {3, 0},
                        {3, 1},
                        {3, 3},
                        {3, 4},
                        {4, 0},
                        {4, 3},
                        {4, 5},
                        {5, 0},
                        {5, 1},
                        {5, 2},
                        {5, 4},
                        {5, 5}
                }));
    }

    /**
     * @param n         工件个数
     * @param artifacts 工件埋藏
     * @param dig       挖掘列表
     * @return 能挖的工件个数
     */
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] visited = new boolean[n][n];
        for (int[] site : dig) {
            visited[site[0]][site[1]] = true;
        }
        int count = 0;
        for (int[] artifact : artifacts) {
            boolean temp = true;
            int xr = artifact[0];
            int yr = artifact[1];
            int xl = artifact[2];
            int yl = artifact[3];
            for (int i = xr; i <= xl; i++) {
                for (int j = yr; j <= yl; j++) {
                    temp = (temp && visited[i][j]);
                }
            }
            if (temp) {
                count++;
            }
        }
        return count;
    }
}