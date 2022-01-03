package normal.question_1099.TwoSumLessThanK;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an array nums of integers and integer k,
 * return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum
 * and sum < k. If no i, j exist satisfying this equation, return -1.
 * 给你一个整数数组 nums 和整数 k ，返回最大和 sum ，
 * 满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < k 。
 * 如果没有满足此等式的 i,j 存在，则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * 1 <= k <= 2000
 * </pre>
 *
 * @author Jungle
 * @since 2021/7/12 21:56
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
    }

    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length == 1) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                if (sum > ans) {
                    ans = sum;
                }
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
