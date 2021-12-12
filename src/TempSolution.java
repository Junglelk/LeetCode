import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {


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


    @Test
    public void test() {
        System.out.println(subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }


    public long subArrayRanges(int[] nums) {
        long sum = 0;
        // 窗口大小
        for (int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length - i; j++) {
                if (j == 0 || max == nums[j - 1] || min == nums[j - 1]) {
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;
                    for (int k = j; k <= j + i; k++) {
                        max = Math.max(max, nums[k]);
                        min = Math.min(min, nums[k]);
                    }
                } else {
                    max = Math.max(max, nums[j + i]);
                    min = Math.min(min, nums[j + i]);
                }
                sum += max - min;
            }
        }
        return sum;
    }
}

