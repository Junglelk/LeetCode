package question_0120.Triangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <pre>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/9/3 23:21
 */
public class Solution {

    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(-1));
        list.add(List.of(2, 3));
        list.add(List.of(1, -1, -3));
        System.out.println(minimumTotal(list));

    }

    @Test
    public void test01() {
        List<List<Integer>> list = new ArrayList<>();
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        list.add(List.of(2));
        list.add(List.of(3, 4));
        list.add(List.of(6, 5, 7));
        list.add(List.of(4, 1, 8, 3));
        System.out.println(minimumTotal(list));

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i][j] 到第i行第j个位置时的最小路径和
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            int pre = triangle.get(i - 1).size();
            int size = temp.size();
            dp[i][size - 1] = dp[i - 1][pre - 1] + temp.get(size - 1);
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);
            // 一开始这里我写的是j<integers.size()，这会导致比较到最后一个的时候，总会与 0 比较大小。
            // 这样一来，结果就错了。正因为我考虑了三角形的腰，导致写了上面那些无用的代码，，太不好看了
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + integers.get(j), dp[i - 1][j - 1] + integers.get(j));
            }
            dp[i][i] = dp[i - 1][i - 1] + integers.get(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp[dp.length - 1]) {
            min = Math.min(i, min);
        }
        return min;
    }
}
