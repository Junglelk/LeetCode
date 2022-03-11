package normal.easy.question_1446.ConsecutiveCharacters;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * <p>
 * Given a string s, return the power of s.
 * <p>
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量。
 * <pre>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 *  </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/12/2 9:34
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }

    public int maxPower(String s) {
        int temp = 1;
        int max = 1;
        char p = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (p == c) {
                temp++;
            }else {
                p = c;
                temp = 1;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
