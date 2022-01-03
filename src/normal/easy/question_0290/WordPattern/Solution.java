package normal.easy.question_0290.WordPattern;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/4 22:04
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(Arrays.toString(new String[12]));
    }


    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        String[] array = new String[pattern.length()];
        if (pattern.length() != strings.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (array[pattern.charAt(i)] == null) {
                array[pattern.charAt(i)] = strings[i];
            } else {
                if (!array[pattern.charAt(i)].equals(strings[i])) {
                    return false;
                }
            }
        }
        Set<String> set = new HashSet<>();
        int num = 0;
        for (String string : array) {
            if (string != null) {
                set.add(string);
                num++;
            }

        }
        return set.size() == num;
    }
}
