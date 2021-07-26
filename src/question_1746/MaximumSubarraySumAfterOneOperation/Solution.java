package question_1746.MaximumSubarraySumAfterOneOperation;

import org.junit.Test;

/**
 * Description:
 * <p>
 * You are given an integer array nums. You must perform exactly one operation where you can replace one element nums[i] with nums[i] * nums[i]. 
 * <p>
 * Return the maximum possible subarray sum after exactly one operation. The subarray must be non-empty.
 * <p>
 * 你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。
 * <p>
 * 返回替换后的最大子数组和。
 * <pre>
 * 输入：nums = [2,-1,-4,-3]
 * 输出：17
 * 解释：你可以把-4替换为16(-4*(-4))，使nums = [2,-1,16,-3]. 现在，最大子数组和为 2 + -1 + 16 = 17.
 * </pre>
 * <pre>
 * 输入：nums = [1,-1,1,1,-1,-1,1]
 * 输出：4
 * 解释：你可以把第一个-1替换为1，使 nums = [1,1,1,1,-1,-1,1]. 现在，最大子数组和为 1 + 1 + 1 + 1 = 4.
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-sum-after-one-operation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author mk
 * @since 2021/7/26 17:51
 */

public class Solution {

    @Test
    public void test() {
        // 17
        System.out.println(maxSumAfterOperationS(new int[]{2, -1, -4, -3}));
        // 4
        System.out.println(maxSumAfterOperationS(new int[]{1, -1, 1, 1, -1, -1, 1}));
    }

    public int maxSumAfterOperation(int[] nums) {
        // dp[i] 为到第 i 个数时的最大子序列和
        // dp[i][0] 表示到第 i 位时，未做过替换的最大子序列和
        // dp[i][1] 表示到第 i 位时，已做过替换的最大子序列和
        // dp[i][0] = max(dp[i-1][0]+nums[i],nums[i]);
        // dp[i][1] = max(max(dp[i - 1][1] + nums[i], nums[i] * nums[i]), dp[i - 1][0] + nums[i] * nums[i]);
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1] + nums[i], nums[i] * nums[i]), dp[i - 1][0] + nums[i] * nums[i]);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }

    public int maxSumAfterOperationS(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int second = nums[0] * nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            int temp = first;
            first = Math.max(first + nums[i], nums[i]);
            second = Math.max(Math.max(second + nums[i], nums[i] * nums[i]), temp + nums[i] * nums[i]);
            max = Math.max(second, max);
        }
        return max;
    }
}
