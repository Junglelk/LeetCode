package normal.medium.question_0003.LongestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/16 21:01
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring(null));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int result = Integer.MIN_VALUE;

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }
}
