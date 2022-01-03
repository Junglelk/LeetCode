package normal.question_1230.TossStrangeCoins;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * You have some coins.  The i-th coin has a probability prob[i] of facing heads when tossed.
 * <p>
 * Return the probability that the number of coins facing heads equals target if you toss every coin exactly once.
 * <p>
 * 有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。
 * <p>
 * 请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。
 * <p>
 * <pre>
 * 输入：prob = [0.4], target = 1
 * 输出：0.40000
 * </pre>
 * <pre>
 * 输入：prob = [0.5,0.5,0.5,0.5,0.5], target = 0
 * 输出：0.03125
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toss-strange-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/27 13:42
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(probabilityOfHeads(new double[]{0.4, 0.5, 0.6, 0.1, 0.2}, 4));
    }

    public double probabilityOfHeads(double[] prob, int target) {
        if (prob.length == 1) {
            return prob[0];
        }
        if (prob.length == target) {
            double pr = 1.0;
            for (double v : prob) {
                pr *= v;
            }
            return pr;
        }
        // dp[i][j] 为抛到第 i 个硬币，有 j 个硬币朝上的概率 0<=j<=i
        // dp[i][j] = dp[i-1][j] * (1-pron[i]) + dp[i-1][j-1]*prob[i]
        double[][] dp = new double[prob.length][prob.length + 1];
        dp[0][1] = prob[0];
        dp[0][0] = 1 - prob[0];
        for (int i = 1; i < prob.length; i++) {
            for (int j = 0; j <= i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] * (1 - prob[i]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j] * (1 - prob[i]) + dp[i - 1][j - 1] * prob[i];
            }
        }
        return dp[prob.length - 1][target];
    }
}
