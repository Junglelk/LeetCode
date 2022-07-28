package normal.medium.question_0740.DeleteAndEarn;

import org.junit.jupiter.api.Test;

/**
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * <p>
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 * <p>
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * <pre>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * </pre>
 * <pre>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/delete-and-earn">delete-and-earn</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/9/22 20:49
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(deleteAndEarn(new int[]{1, 2, 3, 4}));
    }

    /**
     * 读题可知，选择某一个数字，则与该数字相同的数都需被删除并获得点数。所以将所有相同的数字加起来。
     * 这样一来就能获得每个数字能够获取的点数，进而，如果选择了 x 而 x-1 或者 x+1 能够获取的点数高于 x
     * 我们就可以转选别的。就如同打家劫舍一般的思路
     *
     * @param nums 源数组
     * @return 最大点数
     */
    public int deleteAndEarn(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            // 把所有相同的数字加起来
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
