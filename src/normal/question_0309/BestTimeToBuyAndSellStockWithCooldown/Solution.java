package normal.question_0309.BestTimeToBuyAndSellStockWithCooldown;

import org.junit.jupiter.api.Test;

/**
 * Description:
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:<br>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。<br>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。<br>
 *  
 * <pre>
 * Example 1:
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * </pre>
 * <pre>
 * Example 2:
 * <p>
 * Input: prices = [1]
 * Output: 0
 * </pre>
 *  
 * <pre>
 * Constraints:
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/21 10:19
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    /**
     * 题目要求是“设计一个算法计算出最大利润”，这个最大利润必须满足如下
     * 分析
     *
     * @param prices 价格数组
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
