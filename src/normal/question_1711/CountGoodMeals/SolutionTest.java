package normal.question_1711.CountGoodMeals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jungle
 * @since 2021/7/7 22:06
 */
public class SolutionTest {
    @Test
    public void test() {
        // TODO
        int[] deliciousness = {1, 1, 1, 1, 3, 3, 3, 7};
        System.out.println(countPairs(deliciousness));
    }


    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : deliciousness) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        System.out.println(map);
        return 0;
    }


}
