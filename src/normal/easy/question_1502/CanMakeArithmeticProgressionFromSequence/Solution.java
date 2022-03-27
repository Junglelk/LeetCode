package normal.easy.question_1502.CanMakeArithmeticProgressionFromSequence;

import java.util.Arrays;

/**
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * <p>
 * Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/27 22:37
 */
public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2)
            return true;

        Arrays.sort(arr);

        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++)
            if ((arr[i] - arr[i - 1]) != d)
                return false;

        return true;
    }
}
