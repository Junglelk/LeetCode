package question_0259.ThreeSumSmaller;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p>
 * Given an array of n integers nums and an integer target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * 给定一个长度为 n 的整数数组和一个目标值 target，
 * 寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 * </p>
 * <pre>
 *  输入: nums = [-2,0,1,3], target = 2
 *  输出: 2
 *  解释: 因为一共有两个三元组满足累加和小于 2:
 *       [-2,0,1]
 *       [-2,0,3]
 *  </pre>
 * 来源：力扣（LeetCode）<br>
 * 链接：https://leetcode-cn.com/problems/3sum-smaller<br>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mk
 * @since 2021/7/13 17:54
 */
public class Solution {
    @Test
    public void test() {

    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            list.add(nums[i] + nums[i + 1] + nums[i + 2]);
        }
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int middle = (low + high) >> 1;
            if (list.get(middle) == target || list.get(middle + 1)> target) {
                return middle;
            }else if (list.get(middle) > target){
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return 0;
    }
}
