package question_0121.BestTimeToBuyAndSellStock;

import org.junit.Test;

/**
 * Description:
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 * <p>
 * 来源：力扣（LeetCode）<br>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock<br>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author mk
 * @since 2021/7/19 13:53
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitViolence(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfitViolence(int[] prices) {
        // 暴力求解
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        // 假设我们当前的为最小值，寻找当前之后的所有值中的最大值
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (max < price - min) {
                max = price - min;
            }
        }
        return max;
    }

}
