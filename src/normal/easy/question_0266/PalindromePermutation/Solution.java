package normal.easy.question_0266.PalindromePermutation;

import java.util.HashMap;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "code"
 * Output: false
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: true
 * Example 3:
 * <p>
 * Input: "carerac"
 * Output: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/palindrome-permutation">palindrome-permutation</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/1 11:21
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s.equals("") || s.length() == 1)
            return true;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else
                map.remove(temp);
        }
        if (map.size() == 0 || map.size() == 1)
            return true;
        else
            return false;
    }
}
