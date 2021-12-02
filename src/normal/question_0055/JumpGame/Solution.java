package normal.question_0055.JumpGame;

import org.junit.Test;

/**
 * You are given an integer array nums.
 * <p>
 * You are initially positioned at the array's first index,
 * <p>
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <pre>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/25 22:35
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * 求最长能到哪。记为N，只要 N > nums.length 即可。
     *
     * @param nums 步长数组
     * @return 是否可行
     */
    public boolean canJump(int[] nums) {
        // dp[i] 记录由 0 位置起，能否到达第 i 个位置的状态：是or否。
        boolean[] dp = new boolean[nums.length];
        // 边界条件为：是
        dp[0] = true;
        // dp[i] = true 的条件是：i之前的位置 j 可到达，且从 j 出发可到达 i。
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 状态转移方程
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
