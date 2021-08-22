package competition_5850.FindGreatestCommonDivisorOfArray;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * <p>
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 *
 * @author Jungle
 * @since 2021/8/22 10:30
 */
public class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        while (true) {
            if ((max = max % min) == 0)
                return min;
            if ((min = min % max) == 0)
                return max;
        }
    }
}
