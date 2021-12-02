package competition.medium.competition_5940;

/**
 * You are given a 0-indexed array of distinct integers nums.
 * <p>
 * There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
 * <p>
 * A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.
 * <p>
 * Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
 * 给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
 * <p>
 * nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
 * <p>
 * 一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
 * <p>
 * 返回将数组中最小值和最大值 都 移除需要的最小删除次数。
 *
 * @author Jungle
 * @since 2021/11/28 12:07
 */
public class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int maxP = -1;
        int minP = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                maxP = i;
            }
            if (nums[i] == min) {
                minP = i;
            }
            if (maxP != -1 && minP != -1) {
                break;
            }
        }
        int ret;
        int i = Math.max(maxP, minP);
        int j = Math.min(maxP, minP);
        ret = Math.min(i + 1, Math.min(nums.length - j, nums.length - i + 1 + j));
        return ret;
    }
}
