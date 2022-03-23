package normal.easy.question_0976.LargestPerimeterTriangle;

import java.util.Arrays;

/**
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/23 21:23
 */
public class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] - nums[i - 1] < nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
