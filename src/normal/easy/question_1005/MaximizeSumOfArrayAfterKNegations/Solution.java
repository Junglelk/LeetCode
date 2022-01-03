package normal.easy.question_1005.MaximizeSumOfArrayAfterKNegations;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * Given an integer array nums and an integer k, modify the array in the following way:
 * <p>
 * choose an index i and replace nums[i] with -nums[i].
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 * <p>
 * Return the largest possible sum of the array after modifying it in this way.
 * <p>
 *  
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author mk
 * @since 2021/12/3 9:38
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int reverse = -1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    reverse = j;
                }
            }
            nums[reverse] = -nums[reverse];
            min = Integer.MAX_VALUE;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
