package competition.medium.competition_5953.SumOfSubarrayRanges;

/**
 * You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
 * <p>
 * Return the sum of all subarray ranges of nums.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * <p>
 * 返回 nums 中 所有 子数组范围的 和 。
 * <p>
 * 子数组是数组中一个连续 非空 的元素序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/12 22:06
 */
public class Solution {
    /**
     * 之前的方法会超时<br>
     * 根本原因是没能理解滑动窗口，妄想通过数组复制作为银弹去解题，陷入了思维误区
     *
     * @param nums 数组
     * @return 和
     */
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        // 窗口大小
        for (int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length - i; j++) {
                if (j == 0 || max == nums[j - 1] || min == nums[j - 1]) {
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;
                    for (int k = j; k <= j + i; k++) {
                        max = Math.max(max, nums[k]);
                        min = Math.min(min, nums[k]);
                    }
                } else {
                    max = Math.max(max, nums[j + i]);
                    min = Math.min(min, nums[j + i]);
                }
                sum += max - min;
            }
        }
        return sum;
    }

}
