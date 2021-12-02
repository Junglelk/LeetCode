package normal.question_1150.CheckNumberIsMajorityElementInSortedArray;


import org.junit.Test;

/**
 * 检查一个数是否在数组中占绝大多数
 * Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
 * <p>
 * A majority element is an element that appears more than N/2 times in an array of length N.
 * <p>
 * 给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
 * <p>
 * 所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/10 22:17
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(isMajorityElement(new int[]{1,2,3,3,3,3,3,3,3,5},3));
    }


    public boolean isMajorityElement(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;
        if (nums.length == 2) return nums[0] == target && nums[1] == target;
        int mid = (nums.length - 1) >> 1;
        int count = 0;
        for (int i = mid - 1; i <= mid + 1; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count >= 2;
    }

}
