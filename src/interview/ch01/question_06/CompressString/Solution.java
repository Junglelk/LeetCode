package interview.ch01.question_06.CompressString;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/compress-string-lcci">compress-string-lcci</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/6/22 22:12
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(compressString("aaaabbcdddddddddeeeef"));
    }


    public String compressString(String S) {

        if ("".equals(S) || S == null) {
            return S;
        }

        StringBuilder stb = new StringBuilder();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                stb.append(ch);
                stb.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        stb.append(ch);
        stb.append(cnt);

        return stb.length() >= S.length() ? S : stb.toString();
    }
}
