package normal.medium.question_0581.ShortestUnsortedContinuousSubarray;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }


    public int findUnsortedSubarray(int[] nums) {
        int[] ints = new int[nums.length];
        System.arraycopy(nums, 0, ints, 0, nums.length);
        Arrays.sort(ints);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != ints[i]) {
                ret.add(nums[i]);
            }
        }
        return ret.size();
    }
}
