package interview.ch01.question_01.IsUniqueLCCI;

/**
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
