package normal.medium.question_1711.CountGoodMeals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness
 * equal to a power of two.
 *
 * <p>You can pick any two different foods to make a good meal.
 *
 * <p>Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i
 * th item of food, return the number of different good meals you can make from this list modulo 109
 * + 7.
 *
 * <p>Note that items with different indices are considered different even if they have the same
 * deliciousness value.
 *
 * <p>大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * <p>你可以搭配 任意 两道餐品做一顿大餐。
 *
 * <p>给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐
 * 的数量。结果需要对 109 + 7 取余。
 *
 * <p>注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * <pre>
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * </pre>
 *
 * <p>来源：力扣（LeetCode） 链接：<a href="https://leetcode-cn.com/problems/count-good-meals">count-good-meals</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/7 22:06
 */
public class SolutionTest {
    @Test
    public void test() {
        int[] deliciousness = {1, 1, 1, 1, 3, 3, 3, 7};
        System.out.println(countPairs(deliciousness));
    }


    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}
