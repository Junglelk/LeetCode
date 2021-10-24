package competition_5906.NumberOfValidWordsInASentence;

/**
 * A sentence consists of lowercase letters ('a' to 'z'), digits ('0' to '9'), hyphens ('-'), punctuation marks ('!', '.', and ','), and spaces (' ') only. Each sentence can be broken down into one or more tokens separated by one or more spaces ' '.
 * <p>
 * A token is a valid word if:
 * <p>
 * It only contains lowercase letters, hyphens, and/or punctuation (no digits).
 * There is at most one hyphen '-'. If present, it should be surrounded by lowercase characters ("a-b" is valid, but "-ab" and "ab-" are not valid).
 * There is at most one punctuation mark. If present, it should be at the end of the token.
 * Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".
 * <p>
 * Given a string sentence, return the number of valid words in sentence.
 * <p>
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 * <p>
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 * <p>
 * 仅由小写字母、连字符和/或标点（不含数字）。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 * <p>
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/24 12:31
 */
public class Solution {
    /**
     * 仅由小写字母、连字符和/或标点（不含数字）。
     * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
     * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
     *
     * @param sentence
     * @return
     */
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        String rex = "^[a-z]+$|^[a-z]+-?[a-z]+$|[a-z]*[.,!]?$|^[a-z]+-?[a-z]+[,!.]?$";
        int nums = 0;
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            if (word.matches(rex)) {
                nums++;
            }
        }
        return nums;
    }
}
