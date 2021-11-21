package normal.question_0238.ProductOfArrayExceptSelf;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * 给你一个长度为 n 的整数数组 nums，
 * 其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * <pre>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/16 21:22
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    /**
     * 1、确定dp数组的涵义---->储存到每一个位置dp[i][j]上，有多少种路径<br>
     * 2、确定确定递推公式---->dp[i][j] = trans(dp[i-1][j]、dp[i-1][j-1]、dp[i][j-1])<br>
     * 3、确定dp数组如何初始化----> dp[i][0]和dp[0][j]的整行和整列，都是只有一条路径，因为只能向下或者向右<br>
     * 4、确定遍历顺序---->依据所求目标确定<br>
     * 5、举例推导dp数组<br>
     * <p>
     * 对于本题，dp数组并不方便。要求是除当前数字外的其他数字的乘机。
     * <p>
     * 首先想到当前数组所有数字做一个乘积，然后再除以当前数字，然而需要处理的边界条件为：<br>
     * 1. 当前数字为 0 ；<br>
     * 2. 其余数字有 0。<br>
     * <p>
     * 显然，这种方法并不优雅。再考虑，由于是一维数组，且除本数字之外的所有其他数字的乘积。<br>
     * ”其他数字“，<br>
     * 有何本义特征？<br>
     * 1. 显然非本数字。<br>
     * 2. 其余全体<br>
     * 有何空间特征？<br>
     * 1. 在当前数字左侧和右侧。<br>
     * <p>
     * 左侧求总积，右侧求总积，则对应位置除当前数字外的整积为左侧相对位置和右侧相对位置的两数字之积
     *
     * @param nums 源数组
     * @return 目标数组
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] target = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        right[n - 1] = 1;
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < target.length; i++) {
            target[i] = left[i] * right[i];
        }
        return target;
    }
}
