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
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j ++) {
                int[] temp = new int[i + 1];
                System.arraycopy(nums, j, temp, 0, i + 1);
                sum += getRange(temp);
            }
        }
        return sum;
    }

    long getRange(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(min, num);
        }
        return max - min;
    }


}

