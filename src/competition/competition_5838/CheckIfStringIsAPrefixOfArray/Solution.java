package competition.competition_5838.CheckIfStringIsAPrefixOfArray;

import org.junit.Test;

/**
 * 前缀数组
 *
 * @author Jungle
 * @since 2021/8/8 10:31
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"}));
    }

    public boolean isPrefixString(String s, String[] words) {
        StringBuffer ans = new StringBuffer();
        for (String word : words) {
            ans.append(word);

            if (ans.length() == s.length()) {
                break;
            }
        }
        return s.equals(ans.toString());
    }
}
