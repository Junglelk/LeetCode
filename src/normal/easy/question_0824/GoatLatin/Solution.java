package normal.easy.question_0824.GoatLatin;

/**
 * You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
 * For example, the word "apple" becomes "applema".
 * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 * Return the final sentence representing the conversion from sentence to Goat Latin.
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/goat-latin">https://leetcode-cn.com/problems/goat-latin</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/21 23:23
 */
public class Solution {
    public String toGoatLatin(String s) {
        int n = s.length();
        String last = "a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0) {
                sb.append(s.substring(i, j)).append("ma");
            } else {
                sb.append(s.substring(i + 1, j)).append(s.charAt(i)).append("ma");
            }
            sb.append(last);
            last += "a";
            i = j + 1;
            if (i < n) sb.append(" ");
        }
        return sb.toString();
    }
}
