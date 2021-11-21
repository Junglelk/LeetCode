package normal.question_1048.LongestStringChain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 * <p>
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere <br>
 * in wordA without changing the order of the other characters to make it equal to wordB.
 * <p>
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, <br>
 * where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. <br>
 * A single word is trivially a word chain with k == 1.<br>
 * <p>
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 * <p>
 * 给出一个单词列表，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。
 * <p>
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
 * <p>
 * <pre>
 * 输入：["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 "a","ba","bda","bdca"。
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-string-chain
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/11 23:33
 */
public class Solution {

    @Test
    public void test() {
//        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(longestStrChain(new String[]{"abcd","dbqca"}));

    }


    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            String a = words[i];
            for (int j = i + 1; j < n; j++) {
                String b = words[j];
                if (isPredecessor(a, b)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(dp[j], res);
                }
            }
        }
        return res + 1;
    }


    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        int m = a.length(), n = b.length();
        if ((m + 1) != n) return false;
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == m;
    }

    public boolean isBefore(String before, String after) {
        if (after.length() - before.length() != 1) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < before.length(); i++) {
            if (after.contains(before.charAt(i) + "")) {
                num++;
            }
        }
        return after.length()-num == 1;
    }
}
