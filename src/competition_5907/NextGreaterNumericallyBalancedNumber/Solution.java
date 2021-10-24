package competition_5907.NextGreaterNumericallyBalancedNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jungle
 * @since 2021/10/24 12:30
 */
public class Solution {
    public int nextBeautifulNumber(int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            String temp = i + "";
            for (int j = 0; j < temp.length(); j++) {
                char key = temp.charAt(j);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            if (match(map)) {
                if (i > n) {
                    return i;
                }
            }
            map.clear();
        }
        return 0;
    }

    public boolean match(Map<Character, Integer> map) {
        for (Character character : map.keySet()) {
            if (character - '0' != map.get(character)) {
                return false;
            }
        }
        return true;
    }
}
