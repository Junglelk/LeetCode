package normal.medium.question_0686.RepeatedStringMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
 * <p>
 * Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and repeated 2 times is "abcabc".
 * <p>
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * <p>
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/22 23:10
 */
public class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int count = 1;
        char c = b.charAt(0);
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (c == a.charAt(i)) {
                points.add(i);
            }
        }
        if (points.isEmpty()) {
            return -1;
        }
        for (Integer point : points) {
            count = 1;
            for (int i = 0; i < b.length(); i++) {
                if (point == n) {
                    count++;
                    point %= n;
                }
                if (a.charAt(point) == b.charAt(i)) {
                    point++;
                } else {
                    break;
                }
                if (i == b.length() - 1) {
                    return count;
                }
            }
        }

        return -1;
    }
}
