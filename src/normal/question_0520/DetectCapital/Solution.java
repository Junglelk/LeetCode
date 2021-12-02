package normal.question_0520.DetectCapital;

import org.junit.Test;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <pre>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * </pre>
 * Given a string word, return true if the usage of capitals in it is right.
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <pre>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 *  </pre>
 * <p>
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/13 19:30
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("GooglE"));
        System.out.println(detectCapitalUse("google"));
        System.out.println(detectCapitalUse("GOOGLE"));
    }


    public boolean detectCapitalUse(String word) {
        String regex = "^[A-Z]+$|^[A-Z]{1}[a-z]+$|^[a-z]+$";
        return word.matches(regex);
    }
}
