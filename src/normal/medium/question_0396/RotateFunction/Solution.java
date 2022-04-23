package normal.medium.question_0396.RotateFunction;

import java.util.Arrays;

/**
 * You are given an integer array nums of length n.
 * <p>
 * Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:
 * <p>
 * <li/>F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 * Return the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * 给定一个长度为 n 的整数数组 nums 。
 * <p>
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 * <p>
 * <li/>F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 * <p>
 * 生成的测试用例让答案符合 32 位 整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/rotate-function">https://leetcode-cn.com/problems/rotate-function</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/22 23:47
 */
public class Solution {
    /**
     * 记数组 nums 的元素之和为 numSum。根据公式，可以得到：
     *
     * <li>F(0)=0×nums[0]+1×nums[1]+…+(n−1)×nums[n−1]</li>
     * <li>F(1)=1×nums[0]+2×nums[1]+…+0×nums[n−1]=F(0)+numSum−n×nums[n−1]</li>
     *
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode-cn.com/problems/rotate-function/solution/xuan-zhuan-shu-zu-by-leetcode-solution-s0wd/">https://leetcode-cn.com/problems/rotate-function/solution/xuan-zhuan-shu-zu-by-leetcode-solution-s0wd/</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums 待求数组
     * @return ans
     */
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }
}
