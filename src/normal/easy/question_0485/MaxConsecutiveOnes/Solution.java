package normal.easy.question_0485.MaxConsecutiveOnes;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array. *
 *
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/max-consecutive-ones">max-consecutive-ones</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Jungle
 * @since 2021/9/25 23:28
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
