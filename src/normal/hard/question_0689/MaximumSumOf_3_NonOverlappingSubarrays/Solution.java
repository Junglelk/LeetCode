package normal.hard.question_0689.MaximumSumOf_3_NonOverlappingSubarrays;

/**
 * Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
 * <p>
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/8 21:34
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0;
        int maxSum1 = 0;
        int maxSum1Idx = 0;
        int sum2 = 0;
        int maxSum12 = 0;
        int maxSum12Idx1 = 0;
        int maxSum12Idx2 = 0;
        int sum3 = 0;
        int maxTotal = 0;
        // 第一个窗口是 0 ~ k - 1
        // 第二个窗口是 k ~ 2k - 1
        // 第三个窗口是 2k ~ 3k - 1
        for (int i = k * 2; i < nums.length; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            // 当大于等于 3k - 1 时，说明三个窗口均已就位，可以进行最大值判断
            if (i >= k * 3 - 1) {
                // 分别更新各个窗口的和的最大值和下标起始值
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                // 由于是总和的判断，所以要进行复合判断
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - k * 2 + 1;
                }
                if (maxSum12 + sum3 > maxTotal) {
                    maxTotal = maxSum12 + sum3;
                    ans[0] = maxSum12Idx1;
                    ans[1] = maxSum12Idx2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }
}