package normal.easy.question_0747.LargestNumberAtLeastTwiceOfOthers;

import org.junit.jupiter.api.Test;

/**
 * You are given an integer array nums where the largest integer is unique.
 * <p>
 * Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/13 21:19
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
    }

    public int dominantIndex(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return first > second << 1 ? index : -1;
    }
}
