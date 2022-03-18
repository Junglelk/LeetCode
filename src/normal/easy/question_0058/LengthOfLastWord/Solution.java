package normal.easy.question_0058.LengthOfLastWord;

/**
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/18 22:36
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i)!=' '){
                j++;
                continue;
            }
            break;
        }
        return j;
    }
}
