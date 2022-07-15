package normal.easy.question_0448.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array">find-all-numbers-disappeared-in-an-array</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            list.add(i);
        }
        for (int num : nums) {
            list.remove(num);
        }
        return new ArrayList<>(list);
    }
}
