package competition.easy.competition_5942.Finding3_DigitEvenNumbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array digits, where each element is a digit. The array may contain duplicates.
 * <p>
 * You need to find all the unique integers that follow the given requirements:
 *
 * <pre>
 * The integer consists of the concatenation of three elements from digits in any arbitrary order.
 * The integer does not have leading zeros.
 * The integer is even.
 * For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
 * </pre>
 * Return a sorted array of the unique integers.
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * <p>
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 *
 * <pre>
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * </pre>
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/finding-3-digit-even-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/5 15:01
 */
public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int point = 0;
        for (int i = 0; i < digits.length ; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (digits[i] != 0 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }

        int[] ret = new int[nums.size()];
        for (Integer num : nums) {
            ret[point++] = num;
        }

        Arrays.sort(ret);
        return ret;
    }
}
