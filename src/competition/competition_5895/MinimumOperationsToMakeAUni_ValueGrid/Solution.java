package competition.competition_5895.MinimumOperationsToMakeAUni_ValueGrid;

import org.junit.Test;

import java.util.Arrays;

/**
 * You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
 * <p>
 * A uni-value grid is a grid where all the elements of it are equal.
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * <p>
 * 单值网格 是全部元素都相等的网格。
 * <p>
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1
 * Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
 *
 * @author Jungle
 * @since 2021/10/10 10:48
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(minOperations(new int[][]{{1, 5}, {2, 3}}, 1));
    }


    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        int[] temp = new int[m * n];
        int i = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                temp[i++] = anInt;
            }
        }
        Arrays.sort(temp);

        int j = temp[(n * m) / 2];
        int sum = 0;
        for (int a : temp) {
            int l = Math.abs(j - a);
            if (l % x != 0) {
                return -1;
            }
            // 就这行代码没想起来，但虽想到中位数，为什么中位数可以成为判断依据呢？有些不能理解
            sum += l / x;
        }
        return sum;
    }
}
