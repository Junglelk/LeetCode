package normal.question_0122.BestTimeToBuyAndSellStockII;

import org.junit.Test;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/21 23:04
 */
public class Solution {
    @Test
    public void test() {
        // 7
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        // 4
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        // 162
        System.out.println(maxProfit(new int[]{7,1,5,3,6,7,8,5,2,4,5,87,8,6,2,1,4,5,2,0,1,47,7,5,1,4,9,2,11,4}));
        System.out.println(maxProfitS(new int[]{7,1,5,3,6,7,8,5,2,4,5,87,8,6,2,1,4,5,2,0,1,47,7,5,1,4,9,2,11,4}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length ==1) {
            return 0;
        }
        // dp[i][0] 表示第 i 天结束后，手里有股票的最大收益
        // dp[i][1] 表示第 i 天结束后，手里无股票的最大收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
    public int maxProfitS(int[] prices) {
        if(prices.length ==1) {
            return 0;
        }
        int pre = -prices[0];
        int cur = 0;
        for (int i = 1; i < prices.length; i++) {
            pre = Math.max(cur - prices[i], pre);
            cur = Math.max(cur, pre + prices[i]);
        }
        return cur;
    }
}
