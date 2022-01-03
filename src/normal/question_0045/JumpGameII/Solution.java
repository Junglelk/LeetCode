package normal.question_0045.JumpGameII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <pre>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/26 20:55
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * @param nums 步长数组
     * @return 最小步数
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10001);
        // dp[i] 为到达 i 位置处跳跃的最小次数
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
            }
        }
        return dp[nums.length - 1];
    }
}
