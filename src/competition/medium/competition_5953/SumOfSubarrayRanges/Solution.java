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
    // 可行解，但肉眼可见的高时间复杂度
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j ++) {
                int[] temp = new int[i + 1];
                System.arraycopy(nums, j, temp, 0, i + 1);
                sum += getRange(temp);
            }
        }
        return sum;
    }

    long getRange(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(min, num);
        }
        return max - min;
    }

}
