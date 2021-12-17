package normal.medium.question_0059.SpiralMatrixII;

import org.junit.Test;

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
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        // 右下至左上,
        // (x,y) 将directions的内部加一遍的结果是：
        // x , y + 1 -> 向右 -> x + 1 ,y -> 向下 -> x , y-1 -> 向左 -> x-1 , y -> 向上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                // 顺时针旋转
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }
}