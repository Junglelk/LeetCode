package normal.easy.question_0013.RomanToInteger;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <pre>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </pre>
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * * I can be placed before V (5) and X (10) to make 4 and 9. <br>
 * * X can be placed before L (50) and C (100) to make 40 and 90. <br>
 * * C can be placed before D (500) and M (1000) to make 400 and 900.<br>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。<br>
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 <br>
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。<br>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/17 22:50
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(romanToInt("LVIII"));
    }

    Map<Character, Integer> trans = new HashMap<>();

    public Solution() {
        trans.put('I', 1);
        trans.put('V', 5);
        trans.put('X', 10);
        trans.put('L', 50);
        trans.put('C', 100);
        trans.put('D', 500);
        trans.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = trans.get(s.charAt(i));
            if (i < n - 1 && value < trans.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

}
