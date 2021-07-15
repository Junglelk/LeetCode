package question_0053.MaximumSubarray;

/**
 * Description:
 * <p>
 *  给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * </p>
 *
 * @author mk
 * @since 2021/7/15 18:00
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        // 8个月前我的解法
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        //只加并存储连续的正数，因为但凡出现负数就说明原子序列已不是最大
        return ans;
    }
}
