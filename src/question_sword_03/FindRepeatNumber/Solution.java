package question_sword_03.FindRepeatNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * <pre>
 * 2 <= n <= 100000
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/15 21:46
 */
public class Solution {
    /**
     * 可以简单地进行统计各个数字的个数，并返回个数大于一的数字。
     * <p>
     * 优点是可以应对规格外的问题
     *
     * @param nums 待处理数组
     * @return 重复的数字
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > 1) {
                return integer;
            }
        }
        return -1;
    }

    /**
     * 由于数字在0~n-1内，所以可以直接进行在num处进行插入，若已有数字，则说明重复
     *
     * @param nums 待处理数组
     * @return 重复的数字
     */
    public int findRepeatNumberOther(int[] nums) {
        int[] ints = new int[nums.length];
        Arrays.fill(ints, -1);
        for (int num : nums) {
            if (ints[num] != -1) {
                return num;
            }
            ints[num] = num;
        }
        return -1;
    }
}
