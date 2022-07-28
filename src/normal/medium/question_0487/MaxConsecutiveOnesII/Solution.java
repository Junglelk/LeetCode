package normal.medium.question_0487.MaxConsecutiveOnesII;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 * <p>
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * 来源：力扣（LeetCode）<br>
 * 链接：<a href="https://leetcode-cn.com/problems/max-consecutive-ones-ii">max-consecutive-ones-ii</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * <pre>
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 * </pre>
 *
 * @author Jungle
 * @since 2021/7/22 10:21
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 0, 1, 1, 0}));
        System.out.println(findMaxConsecutiveOnesRe(new int[]{1, 1, 1, 1, 1, 0, 1, 1, 0}));
    }

    int zeroNum = 0;

    public int findMaxConsecutiveOnes(int[] nums) {
        // 把数组想象成为流，初始状态在 A ，状态A接收到 1或者0， 计数，连续接收到两个 0 终止，恢复初始状态
        int count = 0;
        int temp = 0;
        int back = 0;
        int backCount = 0;
        for (int num : nums) {
            if (status(num)) {
                count++;
                temp = Math.max(temp, count);
            } else {
                count = 0;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (status(nums[i])) {
                backCount++;
                back = Math.max(back, backCount);
            } else {
                backCount = 0;
            }
        }
        return Math.max(back, temp);
    }

    /**
     * 定义 dp[i][0]为考虑到以 i 为结尾未使用操作将 [0,i]某个 0 变成 1 的最大的连续 1 的个数，<br>
     * &NBSP;&NBSP;&NBSP;&NBSP;&NBSP;&NBSP;&NBSP;&NBSP;dp[i][1] 为考虑到以 i 为结尾使用操作将 [0,i] 某个 0 变成 1 的最大的连续 1 的个数。<br>
     * 则我们可以列出转移式：
     * <pre>
     *            |-> dp[i-1][0]+1, nums[i] = 1;
     * dp[i][0] = |
     *            |->      0      , nums[i] = 0
     * 和
     *            |-> dp[i-1][1]+1, nums[i] = 1,
     * dp[i][1] = |
     *            |-> dp[i-1][0]+1, nums[i] = 0
     * </pre>
     * 解释一下，针对 dp[i][0] ，如果当前位置是 0 ，由于未使用操作，所以肯定是 0 ，如果是 1 ，则从前一个位置未使用操作的状态转移过来即可。
     * 针对 dp[i][1] ，如果当前位置是 0 ，则我们操作肯定是要用在这个位置，把它变成 1 ，所以只能从前一个未使用过操作的状态转移过来，如果是 1  ，则从前一个已经使用过操作的状态转移过来。
     * <p>
     * 最后答案就是 max(dp[i][0],dp[i][1])。
     * <p>
     * 到这里其实还并不能解决进阶问题，因为开 dp 数组仍然需要提前知道数组的大小，但是我们注意到每次转移只与前一个位置有关，
     * 所以我们并不需要开数组，只需要额外两个变量记录一下前一个位置的两个状态即可，这样我们就可以有效解决进阶的问题。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii/solution/zui-da-lian-xu-1de-ge-shu-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums 待解数组
     * @return 答案
     */
    public int findMaxConsecutiveOnesRe(int[] nums) {
        int ans = 0, dp0 = 0, dp1 = 0;
        for (int num : nums) {
            if (num == 1) {
                dp1++;
                dp0++;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }

    public boolean status(int num) {
        if (num == 1) {
            return true;
        } else if (num == 0) {
            if (zeroNum == 0) {
                zeroNum++;
                return true;
            } else {
                zeroNum = 0;
                return false;
            }
        }
        return false;
    }
}
