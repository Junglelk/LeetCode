package competition.competition_5864.TheNumberOfWeakCharactersInTheGame;

import org.junit.jupiter.api.Test;

/**
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，
 * <p>
 * 其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * <p>
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，
 * <p>
 * 则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * <p>
 * 返回 弱角色 的数量。
 * <pre>
 * 输入：properties = [[2,2],[3,3]]
 * 输出：1
 * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * </pre>
 * <pre>
 * 输入：properties = [[1,5],[10,4],[4,3]]
 * 输出：1
 * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * </pre>
 * <pre>
 * 输入：properties = [[5,5],[6,3],[3,6]]
 * 输出：0
 * 解释：不存在攻击和防御都严格高于其他角色的角色。
 * </pre>
 * <pre>
 * 2 <= properties.length <= 10^5
 *   properties[i].length == 2
 * 1 <= attacki, defensei <= 10^5
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/5 10:46
 */
public class Solution {
    @Test
    public void test() {
//        System.out.println(numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}, {6, 2}}));
        // [[7,7],[1,2],[9,7],[7,3],[3,10],[9,8],[8,10],[4,3],[1,5],[1,5]]
        System.out.println(numberOfWeakCharacters(new int[][]{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}}));
    }


    public int numberOfWeakCharacters(int[][] properties) {
        int weak = 0;
        int[] pre = properties[1];
        for (int i = 0; i < properties.length; i++) {
            // 假定弱角色
            int[] temp = properties[i];
            for (int j = i+1; j < properties.length; j++) {
                if (i != j) {
                    // 假定强角色
                    int[] temp1 = properties[j];
                    // 本次强角色强于上次的强角色
                    if (temp[0] < temp1[0] && temp[1] < temp1[1]) {
                        // 记录此次强角色
                        pre = temp1;
                        weak++;
                    }
                }

            }
        }
        return weak;
    }
}
