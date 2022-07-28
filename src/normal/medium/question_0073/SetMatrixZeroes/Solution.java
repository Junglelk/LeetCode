package normal.medium.question_0073.SetMatrixZeroes;

import java.util.*;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * <p>
 * You must do it in place.
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/set-matrix-zeroes">set-matrix-zeroes</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/19 21:26
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
            }
        }

        for (Integer row : map.keySet()) {
            // 将第i行灌成0
            Arrays.fill(matrix[row], 0);
            for (Integer col : map.get(row)) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }
}
