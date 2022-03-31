package normal.medium.question_0054.SpiralMatrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 *
 * <pre>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/29 22:39
 */
public class Solution {

    @Test
    public void test() {
        // [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        }));

    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        long count = 0;
        long nums = (long) m * n;
        int i = 0, j = 0;
        int it, jt;

        while (count != nums) {
            it = i;
            jt = j;
            for (int k = j; k < n; k++) {
                list.add(matrix[i][k]);
                count++;
                j = k;
            }
            if (count == nums) break;
            i++;
            for (int k = i; k < m; k++) {
                list.add(matrix[k][j]);
                count++;
                i = k;
            }
            if (count == nums) break;
            j--;
            for (int k = j; k >= jt; k--) {
                list.add(matrix[i][k]);
                count++;
                j = k;
            }
            if (count == nums) break;
            i--;
            for (int k = i; k >= it + 1; k--) {
                list.add(matrix[k][j]);
                count++;
                i = k;
            }
            if (count == nums) break;
            j++;

            m--;
            n--;
        }
        return list;

    }
}
