package question_0213.HouseRobberII;

import org.junit.Test;

/**
 * Description:
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 *
 * @author mk
 * @since 2021/7/16 17:31
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 5, 3, 9, 5, 2, 5, 7, 12}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHandler(nums, 0, nums.length - 1), robHandler(nums, 1, nums.length));
    }

    public int robHandler(int[] nums, int start, int end) {
        int pre = nums[start];
        int result = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = result;
            result = Math.max(pre + nums[i], result);
            pre = temp;
        }
        return result;
    }
}
