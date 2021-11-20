package question_0594.LongestHarmoniousSubsequence;

import org.junit.Test;

/**
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * <pre>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/20 21:39
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }


    public int findLHS(int[] nums) {
        int length = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i];
            length++;
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j] || temp == nums[j] + 1) {
                    length++;
                }
            }
            result = Math.max(length, result);
            length = 0;
        }
        return result;
    }
}
