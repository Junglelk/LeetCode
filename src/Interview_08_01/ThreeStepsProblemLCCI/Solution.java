package Interview_08_01.ThreeStepsProblemLCCI;

import org.junit.Test;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/13 23:13
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(waysToStep(1000000));
    }

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }

        long dp1 = 1;
        long dp2 = 2;
        long dp3 = 4;

        long mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            long temp = (dp1 + dp2 + dp3) % mod;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = temp;
        }
        return (int) (dp3 % mod);
    }
}
