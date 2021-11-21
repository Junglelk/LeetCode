package competition.competition_5823.TransString;

import org.junit.Test;

import java.math.BigInteger;

/**
 * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
 * <p>
 * 首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
 * <p>
 * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
 * <p>
 * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * 转换 #2：17 ➝ 1 + 7 ➝ 8
 * 返回执行上述操作后得到的结果整数。
 *
 * @author Jungle
 * @since 2021/7/25 10:33
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(getLucky("leetcode", 10));
    }

    public int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nums = s.charAt(i) - 96;
            str.append(nums);
        }
        String string = str.toString();
        while (k > 0) {
            string = trans(string) + "";
            k--;
        }
        return Integer.parseInt(string);
    }

    public int trans(String s) {
        int result = 0;
        BigInteger temp = new BigInteger(s);
        BigInteger ten = new BigInteger("10");
        while (temp.intValue() != 0) {
            result += temp.mod(ten).intValue();
            temp = temp.divide(ten);
        }
        return result;
    }
}
