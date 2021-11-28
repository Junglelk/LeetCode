package competition.medium.competition_5939;

import java.util.Arrays;

/**
 * You are given a 0-indexed array nums of n integers, and an integer k.
 * <p>
 * The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
 * <p>
 * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
 * <p>
 * The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
 * <p>
 * For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 3.75, which truncates to 3.
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
 * <p>
 * 半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
 * <p>
 * 构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
 * <p>
 * x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
 * <p>
 * 例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 3.75，截断后得到 3 。
 *
 * @author Jungle
 * @since 2021/11/28 12:09
 */
public class Solution {
    /**
     * @param nums 数组
     * @param k    目标值
     * @return 平均数组
     */
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int r = 2 * k + 1;
        int[] list = new int[nums.length];
        if (r > nums.length) {
            Arrays.fill(list, -1);
            return list;
        }
        if (r == nums.length) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            list[r / 2] = sum / r;
            Arrays.fill(list, 0, r / 2, -1);
            Arrays.fill(list, r / 2, list.length, -1);
        }
        for (int i = 0; i < nums.length; i++) {
            int[] temp = new int[r];
            if (i - k < 0 || i + k >= nums.length) {
                list[i] = -1;
            } else {
                System.arraycopy(nums, i - k, temp, 0, r);
                int sum = 0;
                for (int num : temp) {
                    sum += num;
                }
                list[i] = sum / r;
            }
        }
        return list;
    }

}
