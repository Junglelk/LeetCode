package normal.question_0053.MaximumSubarray;

import org.junit.Test;

/**
 * Description:
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/15 18:00
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayDb(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 独立解法
     *
     * @param nums 待解决数组
     * @return 最大子序列的和
     */
    public int maxSubArray(int[] nums) {
        // 8个月前我的解法
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        //只加并存储连续的正数，因为但凡出现负数就说明原子序列已不是最大
        return ans;
    }

    /**
     * 我们用 f(i)代表以第 i 个数结尾的「连续子数组的最大和」
     * 状态转移方程：f(i)=max{f(i−1)+nums[i],nums[i]}
     *
     * @param nums 待解决数组
     * @return 最大子序列的和
     */
    public int maxSubArrayDb(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
