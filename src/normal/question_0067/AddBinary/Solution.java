package normal.question_0067.AddBinary;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 这题居然被归类为简单，简单？？？
 *
 * @author Jungle
 * @since 2021/9/17 22:31
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                , "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
