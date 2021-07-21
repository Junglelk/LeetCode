package question_0714.BestTimeToBuyAndSellStockWithTransactionFee;

import org.junit.Test;

/**
 * Description:
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 * <p>
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <pre>
 *      输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 *      输出：8
 *      解释：能够达到的最大利润:
 *      在此处买入 prices[0] = 1
 *      在此处卖出 prices[3] = 8
 *      在此处买入 prices[4] = 4
 *      在此处卖出 prices[5] = 9
 *      总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/7/19 15:17
 */
public class Solution {
    @Test
    public void test() {
        // 这个数组下，答案是 8
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9},2));
        System.out.println(maxProfitG(new int[]{1, 3, 2, 8, 4, 9},2));
    }

    public int maxProfit(int[] prices, int fee) {
        // 状态和状态转移方程。熟悉而头大的概念
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    /**
     * 优化空间复杂度
     * @param prices 价格数组
     * @param fee 交易费
     * @return Integer
     */
    public int maxProfitG(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
