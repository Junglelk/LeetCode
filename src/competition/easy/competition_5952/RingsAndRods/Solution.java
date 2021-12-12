package competition.easy.competition_5952.RingsAndRods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
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
