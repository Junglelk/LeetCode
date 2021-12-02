package normal.question_0476.NumberComplement;

import org.junit.Test;

/**
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 * <p>
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer num, return its complement.
 * <p>
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * <p>
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/18 22:19
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(findComplement(5));
    }

    public int findComplement(int num) {
        int highBit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highBit = i;
            } else {
                break;
            }
        }
        int mask = highBit == 30 ? 0x7fffffff : (1 << (highBit + 1)) - 1;
        return num ^ mask;
    }
}
