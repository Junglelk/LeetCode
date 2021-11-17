package question_sword_42.MaxSubArray;

/**
 * @author Jungle
 * @since 2021/11/17 19:34
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
