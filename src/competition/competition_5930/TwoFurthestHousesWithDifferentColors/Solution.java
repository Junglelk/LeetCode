package competition.competition_5930.TwoFurthestHousesWithDifferentColors;

/**
 * There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
 * <p>
 * Return the maximum distance between two houses with different colors.
 * <p>
 * The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
 * <p>
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 * <p>
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * <p>
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-furthest-houses-with-different-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/21 14:47
 */
public class Solution {
    public int maxDistance(int[] colors) {
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    length = Math.max(length, j - i);
                }
            }
        }
        return length;
    }
}
