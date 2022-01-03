package normal.question_0152.MaximumProductSubarray;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 * </p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * </p>
 * <p>
 * <pre>
 *  输入: [2,3,-2,4]
 *  输出: 6
 *  解释: 子数组 [2,3] 有最大乘积 6。
 * </pre>
 * <pre>
 *  输入: [-2,0,-1]
 *  输出: 0
 *  解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/21 14:54
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{-1, -2, -6}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{2,-6,7,8,9,1,3,-2,4}));
        System.out.println(maxProduct(new int[]{2,-1}));
        System.out.println(maxProduct(new int[]{-2,-2}));
    }

    public int maxProduct(int[] nums) {
        // 由于存在最小负数乘以一个负数直接会变成正数的操作，
        // 所以需要同时维护最小负数与最大正数
        int maxP = nums[0];
        int minP = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxP, min = minP;
            maxP = Math.max(nums[i], Math.max(nums[i] * max, min * nums[i]));
            minP = Math.min(nums[i], Math.min(nums[i] * max, min * nums[i]));
            result = Math.max(maxP, result);
        }
        return result;
    }

    public int maxProductS(int[] nums) {
        // 由于存在最小负数乘以一个负数直接会变成正数的操作，
        // 所以需要同时维护最小负数与最大正数
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
