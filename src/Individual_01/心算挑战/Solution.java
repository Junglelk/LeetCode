package Individual_01.心算挑战;

import java.util.Arrays;

/**
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 *
 *
 * <pre>
 * 示例 1：
 * 输入：cards = [1,2,8,9], cnt = 3
 * 输出：18
 * 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
 * </pre>
 * <pre>
 * 示例 2：
 * 输入：cards = [3,3,1], cnt = 1
 * 输出：0
 * 解释：不存在获取有效得分的卡牌方案。
 * </pre>
 * <pre>
 * 提示：
 * 1 <= cnt <= cards.length <= 10^5
 * 1 <= cards[i] <= 1000
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/11 15:35
 */
public class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        int score = 0;
        Arrays.sort(cards);
        for (int i = cards.length - 1; i >= 0; i--) {
            int temp = cards[i];

        }




        return score;
    }
}
