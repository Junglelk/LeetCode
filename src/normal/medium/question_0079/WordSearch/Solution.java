package normal.medium.question_0079.WordSearch;

import org.junit.jupiter.api.Test;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <pre>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/25 21:39
 */
public class Solution {

    @Test
    public void test() {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        //"ABCCED"
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }


    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, target, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board   需遍历的二维数组
     * @param target  目标字符串
     * @param i       起始位置横坐标
     * @param j       起始位置纵坐标
     * @param visited 是否遍历过标记
     * @param k       遍历到的符合目标字符串的位置
     * @return 是否遍历到目标字符串
     */
    private boolean dfs(char[][] board, char[] target, int i, int j, boolean[][] visited, int k) {
        // 这一步是遍历到了board[i][j]
        if (board[i][j] != target[k]) {
            return false;
        } else if (k == target.length - 1) {
            return true;
        }
        boolean ret = false;
        // 所以要把visited数组置true
        visited[i][j] = true;
        // 遍历board[i][j]的四周
        for (int[] direction : directions) {
            int newI = direction[0] + i;
            int newJ = direction[1] + j;
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!visited[newI][newJ]) {
                    if (newI == 3) {
                        System.out.println(3);
                    }
                    boolean flag = dfs(board, target, newI, newJ, visited, k + 1);
                    if (flag) {
                        ret = true;
                        break;
                    }
                }
            }
        }
        // 下一轮此位置仍然需要走
        visited[i][j] = false;
        return ret;
    }
}
