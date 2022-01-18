package normal.medium.question_1081.SmallestSubsequenceOfDistinctCharacters;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/18 22:21
 */
public class Solution {
    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > chars[i] && lastIndex[stack.peek() - 'a'] > i) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
            }
            stack.push(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder stb = new StringBuilder();
        while (!stack.isEmpty()) {
            stb.append(stack.pop());
        }
        return stb.reverse().toString();
    }
}
