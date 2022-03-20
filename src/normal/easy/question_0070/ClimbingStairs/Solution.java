package normal.easy.question_0070.ClimbingStairs;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。<br>
 * 来源：力扣（LeetCode）<br>
 * 链接：https://leetcode-cn.com/problems/climbing-stairs<br>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br>
 *
 * @author Jungle
 * @since 2021/7/14 23:30
 */
public class Solution {





    public int climbStairs(int n) {
//      本题实际上是斐波那契数列的实现
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
