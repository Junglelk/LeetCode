package normal.medium.question_0540.SingleElementInASortedArray;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 * <p>
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/14 21:22
 */
public class Solution {
    /**
     * 由题意可知，数组的长度是个奇数，而单个数字 single 前后子数组长度均为偶数。<br>
     * 且如果nums[x]==nums[x+1]在 single 左侧时 x 必为偶数（含 0 ），在其右侧时，必为奇数。<br>
     * 又有异或操作的性质，当num为偶数时，num^1 的值为 num+1，num为奇数时，num^1的值为num-1
     *
     * @param nums 待查找数组
     * @return 单一数字
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
