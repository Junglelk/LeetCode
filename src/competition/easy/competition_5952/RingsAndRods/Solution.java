package competition.easy.competition_5952.RingsAndRods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.
 * <p>
 * You are given a string rings of length 2n that describes the n rings that are placed onto the rods. Every two characters in rings forms a color-position pair that is used to describe each ring where:
 * <pre>
 * The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
 * The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
 * </pre>
 * For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
 * <p>
 * Return the number of rods that have all three colors of rings on them.
 * 总计有 n 个环，环的颜色可以是红、绿、蓝中的一种。这些环分布穿在 10 根编号为 0 到 9 的杆上。
 * <p>
 * 给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
 * <pre>
 * 第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。
 * 第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
 * </pre>
 * 例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
 * 找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rings-and-rods
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/12 22:02
 */
public class Solution {
    public int countPoints(String rings) {
        int length = rings.length() / 2;
        String[] nums = new String[length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rings.substring(j, j + 2);
            j += 2;
        }
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (String num : nums) {
            Set<Character> orDefault = map.getOrDefault(num.charAt(1) - '0', new HashSet<>());
            orDefault.add(num.charAt(0));
            map.put(num.charAt(1) - '0', orDefault);
        }
        int count = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer).size() == 3) {
                count++;
            }
        }
        return count;
    }
}
