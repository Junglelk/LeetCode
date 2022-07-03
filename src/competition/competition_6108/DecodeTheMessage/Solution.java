package competition.competition_6108.DecodeTheMessage;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:
 * <p>
 * Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
 * Align the substitution table with the regular English alphabet.
 * Each letter in message is then substituted using the table.
 * Spaces ' ' are transformed to themselves.
 * For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
 * Return the decoded message.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/decode-the-message">decode-the-message</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2022/7/3 22:36
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }


    public String decodeMessage(String key, String message) {
        char[] alpha = new char[26];
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = (char) ('a' + i);
        }
        String replace = key.replace(" ", "");
        char[] chars = replace.toCharArray();
        Map<Character, Character> map = new LinkedHashMap<>();
        int j = 0;
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, alpha[j++]);
            }
        }
        StringBuilder stb = new StringBuilder();
        for (char c : message.toCharArray()) {
            stb.append(map.getOrDefault(c,' '));
        }

        return stb.toString();
    }
}
