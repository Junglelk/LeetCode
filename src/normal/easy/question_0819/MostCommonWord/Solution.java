package normal.easy.question_0819.MostCommonWord;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 * <p>
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 * <p>
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <pre>
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * </pre>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/most-common-word">https://leetcode-cn.com/problems/most-common-word</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/17 23:12
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }


    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        final String[] split = paragraph.split("[!?',;. ]+");
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        for (String str : split) {
            if ("".equals(str)) {
                continue;
            }
            if (!Character.isAlphabetic(str.charAt(str.length() - 1))) {
                str = str.substring(0, str.length() - 1);
            }
            if (!set.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int max = -1;
        String ans = "";
        for (String str : map.keySet()) {
            if (map.get(str) > max) {
                max = map.get(str);
                ans = str;
            }
        }
        return ans;
    }
}
