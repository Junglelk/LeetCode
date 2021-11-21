package normal.question_0198.HouseRobber;

import org.junit.Test;

/**
 * Description:
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is
 * that adjacent houses have security systems connected and it will automatically contact
 * the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police
 *
 * </p>
 *
 * @author Jungle
 * @since 2021/7/16 10:33
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 5, 3, 9, 5, 2, 5, 7, 12}));
    }

    /**
     * 用 dp[i] 表示前 i 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
     * dp[i] = max{dp[i-2]+nums[i],dp[i-1]}
     *
     * @param nums 状态数组
     * @return 最大的总额度
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int result = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = result;
            result = Math.max(pre + nums[i], result);
            pre = temp;
        }
        return result;
    }

    public int robB(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
