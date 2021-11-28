package normal.medium.question_0438.FindAllAnagramsInAString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <pre>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/28 10:23
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }

        int n = p.length();
        int[] chars = new int[26];
        int[] chars1 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a']++;
        }
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            chars1[s.charAt(i) - 'a']++;
            length++;
            if (length > n) {
                chars1[s.charAt(i) - 'a']--;
                length--;
            }
            if (isAnagram(chars1, chars)) {
                ans.add(i - n + 1);
            }

        }
        return ans;
    }

    boolean isAnagram(int[] s, int[] p) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }
}
