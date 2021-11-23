package normal.easy.question_0859.BuddyStrings;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 * <p>
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * <p>
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad"
 * <p>
 * <pre>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/23 21:17
 */
public class Solution {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() == 2) {
            return s.equals(goal) || (s.charAt(0) == goal.charAt(1) && s.charAt(1) == goal.charAt(0));
        }
        int nums = 0;
        int temp1 = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int c1 = goal.charAt(i) - 'a';
            temp1 ^= c;
            temp2 ^= c1;
            if ((c ^ c1) != 0) {
                nums++;
            }
        }
        if (temp1 != temp2) {
            return false;
        }
        return nums == 2;
    }

}
