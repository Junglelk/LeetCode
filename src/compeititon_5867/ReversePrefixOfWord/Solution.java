package compeititon_5867.ReversePrefixOfWord;

import org.junit.Test;

/**
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
 * <p>
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 * <pre>
 * 输入：word = "abcdefd", ch = "d"
 * 输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/12 10:31
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(reversePrefix("axz", 'z'));
    }


    public String reversePrefix(String word, char ch) {
        if (word.contains(ch + "")) {
            StringBuilder stb = new StringBuilder();
            int first = word.indexOf(ch);
            stb.append(word.substring(0, first + 1));
            stb.reverse();
            stb.append(word.substring(first + 1));
            return stb.toString();
        }
        return word;
    }
}
