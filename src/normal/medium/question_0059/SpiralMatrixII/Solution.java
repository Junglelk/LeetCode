package normal.medium.question_0059.SpiralMatrixII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/31 9:41
 */
public class Solution {

    @Test
    public void test() {
        int[][] ints = generateMatrix(5);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }


    public int[][] generateMatrix(int n) {
        int target = n * n;
        int[][] matrix = new int[n][n];

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        int point = 1;
        int index = 0;
        while (point <= target) {
            matrix[row][col] = point++;

            //---------------------
            // 这里做校验并更新下次前进方向
            int nextRow = row + directions[index][0];
            int nextCol = col + directions[index][1];
            if (nextCol >= n || nextCol < 0 || nextRow >= n || nextRow < 0 || matrix[nextRow][nextCol] != 0) {
                index = (index + 1) % 4;
            }
            //---------------------

            row = row + directions[index][0];
            col = col + directions[index][1];
        }
        return matrix;
    }
}