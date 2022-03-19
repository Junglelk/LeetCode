package normal.easy.question_0066.PlusOne;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/19 22:12
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            digits[0] += 1;
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (i == digits.length - 1 && digits[i] != 9) {
                    digits[i] += 1;
                    return digits;
                }
                if ((digits[i] == 9 || digits[i] == 10) && i != 0) {
                    digits[i--] = 0;
                    digits[i] += 1;
                    if (digits[i] != 10) {
                        break;
                    }
                    i++;
                }
            }
        }
        if (digits[0] == 10) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
