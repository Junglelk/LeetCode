package question_0387.FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/8 21:32
 */
public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) == 1) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
