package question_1099.TwoSumLessThanK;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
 * 给你一个整数数组 nums 和整数 k ，返回最大和 sum ，
 * 满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < k 。如果没有满足此等式的 i,j 存在，则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * 1 <= k <= 2000
 *
 * @author mk
 * @since 2021/7/12 15:16
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(twoSumLessThanK(new int[]{358, 898, 450, 732, 672, 672, 256, 542, 320, 573, 423, 543, 591, 280, 399, 923, 920, 254, 135, 952, 115, 536, 143, 896, 411, 722, 815, 635, 353, 486, 127, 146, 974, 495, 229, 21, 733, 918, 314, 670, 671, 537, 533, 716, 140, 599, 758, 777, 185, 549}, 1800));
    }

    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length == 1) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = -1;
        System.out.println(Arrays.toString(nums));
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                ans = sum;
                if (ans == 1796) {
                    System.out.println(nums[left] + "+" + nums[right]);
                }
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}
