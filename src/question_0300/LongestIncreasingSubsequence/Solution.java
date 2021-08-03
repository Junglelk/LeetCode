package question_0300.LongestIncreasingSubsequence;

import org.junit.Test;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or
 * no elements without changing the order of the remaining elements.
 * <p>
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <pre>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/2 23:17
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i - 1];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int temp1 = nums[j];
                if (temp > temp1) {
                    dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return max;
    }
}
