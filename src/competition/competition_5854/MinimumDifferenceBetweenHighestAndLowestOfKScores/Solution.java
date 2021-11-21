package competition.competition_5854.MinimumDifferenceBetweenHighestAndLowestOfKScores;

import org.junit.Test;

import java.util.Arrays;

/**
 * You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
 * <p>
 * Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
 * <p>
 * Return the minimum possible difference.
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * <p>
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * <p>
 * 返回可能的 最小差值 。
 *
 * @author Jungle
 * @since 2021/8/29 10:31
 */
public class Solution {

    @Test
    public void test() {
        //[87063,61094,44530,21297,95857,93551,9918]
        //6
//        System.out.println(minimumDifference(new int[]{90, 32, 69, 14, 58, 96, 21, 478, 115}, 6));
        System.out.println(minimumDifference(new int[]{1, 4, 7, 9}, 2));
        System.out.println(minimumDifference(new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
    }


    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = i; j < nums.length - k + 1; j++) {
                min = Math.min(min, nums[j + k - 1] - nums[i]);
            }
        }
        return min;
    }
}
