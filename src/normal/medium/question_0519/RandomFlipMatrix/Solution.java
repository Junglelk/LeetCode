package normal.medium.question_0519.RandomFlipMatrix;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * There is an m x n binary grid matrix with all the values set 0 initially. Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and flips it to 1. All the indices (i, j) where matrix[i][j] == 0 should be equally likely to be returned.
 * <p>
 * Optimize your algorithm to minimize the number of calls made to the built-in random function of your language and optimize the time and space complexity.
 * <p>
 * Implement the Solution class:
 * <pre>
 * Solution(int m, int n) Initializes the object with the size of the binary matrix m and n.
 * int[] flip() Returns a random index [i, j] of the matrix where matrix[i][j] == 0 and flips it to 1.
 * void reset() Resets all the values of the matrix to be 0.
 * </pre>
 * <p>
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * <p>
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 * <p>
 * 实现 Solution 类：
 * <p>
 * <pre>
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-flip-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/27 21:00
 */
public class Solution {
    private final int m;
    private final int n;
    Set<Integer> set = new HashSet<>();
    Random random = new Random(300);

    public Solution(int _m, int _n) {
        m = _m;
        n = _n;
    }

    public int[] flip() {
        // 小于 m * n 的一个int
        int a = random.nextInt(m * n);
        int b = a;
        while (a >= 0 && set.contains(a)) {
            a--;
        }
        while (b < m * n && set.contains(b)) {
            b++;
        }
        int c =(a >= 0 && !set.contains(a))? a : b;
        set.add(c);
        return new int[]{c / n, c % n};
    }

    public void reset() {
        set.clear();
    }
}