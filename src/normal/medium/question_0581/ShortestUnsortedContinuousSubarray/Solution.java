package normal.medium.question_0581.ShortestUnsortedContinuousSubarray;


import org.junit.jupiter.api.Test;

/**
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 * <p>
 * Return the shortest such subarray and output its length.
 * <p>
 * <pre>
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-unsorted-continuous-subarray">shortest-unsorted-continuous-subarray</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 4, 5}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 5, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
    }


    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE;
        int right = -1;
        int minn = Integer.MAX_VALUE;
        int left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            int j = n - i - 1;
            if (minn < nums[j]) {
                left = j;
            } else {
                minn = nums[j];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
