package normal.question_0300.LongestIncreasingSubsequence;

import org.junit.jupiter.api.Test;

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

    /**
     * 我的错误版本
     *
     * @param nums 数组
     * @return 最大子序列的长度
     */
    public int lengthOfLISError(int[] nums) {
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

    /**
     * 实际的正确版本
     *
     * @param nums 数组
     * @return 最大子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // 由于子序列可以有任意的组合，所以在每一步都需要返回最初始处重新计算到当前位置处的最优解
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // 需要对新到达的位置赋值，赋值为 1 为到当前位置处连续增长最大子序列为 1 即为nums[i] 本身，这样才有比较的基础
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
