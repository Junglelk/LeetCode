package normal.easy.question_0566.ReshapeTheMatrix;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * <p>
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 * <p>
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * <pre>
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/5 22:19
 */
public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //不可行
        int n = mat[0].length;
        int m = mat.length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ret = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            // 官解很奇妙的处理方式
            ret[x / c][x % c] = mat[x / n][x % n];
        }
        return ret;
    }
}
