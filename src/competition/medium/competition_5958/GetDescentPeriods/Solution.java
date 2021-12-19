package competition.medium.competition_5958.GetDescentPeriods;

/**
 * You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
 * <p>
 * A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.
 * <p>
 * Return the number of smooth descent periods.
 * <p>
 * 给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
 * <p>
 * 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
 * <p>
 * 请你返回 平滑下降阶段 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-smooth-descent-periods-of-a-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/19 15:35
 */
public class Solution {
    public long getDescentPeriods(int[] prices) {
        long ret = 1;
        int cnt = 1;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            ret += cnt;
        }
        return ret;
    }
}
