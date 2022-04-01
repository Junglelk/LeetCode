package normal.easy.question_0283.MoveZeroes;

/**
 * Move Zeroes
 * Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 * <pre>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * </pre>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <pre>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * </pre>
 * 说明:
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 *
 * @author Jungle
 * @since 2021/10/6 21:58
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        boolean exch = true;
        int times = 0;
        while (exch) {
            exch = false;
            int temp;
            times++;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    exch = true;
                }
            }
            if (times > nums.length)
                break;
        }
    }
}
