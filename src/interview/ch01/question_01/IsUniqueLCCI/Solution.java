package interview.ch01.question_01.IsUniqueLCCI;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/29 23:05
 */
public class Solution {
    public boolean isUnique(String astr) {
        int[] map = new int[astr.length()];
        for (int i = 0; i < astr.length(); i++) {
            map[astr.charAt(i) - 'a']++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
