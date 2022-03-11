package normal.question_1646.GetMaximumInGeneratedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <pre>
 *  * nums[0] = 0
 *  * nums[1] = 1
 *  * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 *  * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * </pre>
 * <p>
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * <pre>
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 *   nums[0] = 0
 *   nums[1] = 1
 *   nums[(1 * 2) = 2] = nums[1] = 1
 *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 *   nums[(2 * 2) = 4] = nums[2] = 1
 *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 *   nums[(3 * 2) = 6] = nums[3] = 2
 *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/8/6 15:55
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(getMaximumGenerated(2));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i <= n; i++) {
            if (2 <= i * 2 && i * 2 <= n) {
                nums[2 * i] = nums[i];
            }
            if (2 <= i * 2 + 1 && i * 2 + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        Arrays.sort(nums);
        return nums[n];
    }
}
