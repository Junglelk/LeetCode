package normal.question_0125.ValidPalindrome;

import org.junit.Test;

import java.util.Locale;

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/9/14 22:07
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(isPalindrome("0P"));
    }


    public boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        s = s.toLowerCase(Locale.ROOT);
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                stb.append(c);
            }
        }
        String ret = stb.toString();
        String re = stb.reverse().toString();
        return re.equals(ret);
    }
}
