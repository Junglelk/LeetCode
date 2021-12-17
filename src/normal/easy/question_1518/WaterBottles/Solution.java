package normal.easy.question_1518.WaterBottles;

import org.junit.Test;

/**
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 * <p>
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * <p>
 * Return the maximum number of water bottles you can drink.
 * <p>
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/17 21:15
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(numWaterBottles(9, 3));
    }


    public int numWaterBottles(int numBottles, int numExchange) {

        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }
}
