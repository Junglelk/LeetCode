package question_0189.RotateArray;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <pre>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/5 22:36
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }


    public int[] rotate(int[] nums, int k) {
        int length = nums.length;
        int step = k % length;
        if (k == 0 || step == 0) {
            return nums;
        }
        int[] target = new int[length];
        System.arraycopy(nums, length - step, target, 0, step);
        System.arraycopy(nums, 0, target, step, length - step);
        System.arraycopy(target, 0, nums, 0, length);
        return nums;
    }
}
