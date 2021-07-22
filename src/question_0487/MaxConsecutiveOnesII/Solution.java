package question_0487.MaxConsecutiveOnesII;

import org.junit.Test;

/**
 * Description:
 * <p>
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 * <p>
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * 来源：力扣（LeetCode）<br>
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii<br>
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
    public void test(){
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,1,0,1,1,0}));
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
        return Math.max(back,temp);
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
