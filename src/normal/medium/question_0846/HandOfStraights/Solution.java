package normal.medium.question_0846.HandOfStraights;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
 * <p>
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 * <p>
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/30 21:24
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        // 到这里为止，我的想法与官方一致。
        // 我能感觉倒groupSize有其特殊的用法，但我没有意识到究竟该怎么使用。
        for (int i : hand) {
            // 这个保证了每次都是剩余存在的数
            if (!map.containsKey(i)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                // 因为顺子必然是以 1 为步长递增的，所以groupSize就这可以这么验证是否存在顺子
                int x = i + j;
                if (!map.containsKey(x)) {
                    return false;
                }
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) {
                    map.remove(x);
                }
            }
        }
        return true;
    }
}
