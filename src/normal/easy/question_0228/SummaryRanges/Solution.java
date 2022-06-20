package normal.easy.question_0228.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * <li/>"a->b" if a != b
 * <li/>"a" if a == b
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/summary-ranges">summary-ranges</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2022/6/20 21:51
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            if (j == i + 1) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(String.format("%d->%d", nums[i], nums[j - 1]));
            }
            i = j;
        }
        return result;
    }
}
