package normal.medium.question_0034.FindFirstAndLastPositionOfElementInSortedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * <pre>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * </pre>
 * <pre>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * </pre>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/20 22:45
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11)));
    }


    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int left = findLeft(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    private int findRight(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int findLeft(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                r = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }
}
