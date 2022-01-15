package normal.easy.question_1716.CalculateMoneyInLeetcodeBank;

/**
 * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
 * <p>
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
 * <p>
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * <p>
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 * <p>
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/15 21:46
 */
public class Solution {
    public int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        return ((49 + a * 7) * a + (a * 2 + b + 1) * b) >> 1;
    }
}
