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


    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = triangle.get(0).get(0);
        int j = 1;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            if (j >= triangle.size()) {
                sum += temp.get(temp.size() - 1);
            } else {
                Integer a = temp.get(j - 1);
                Integer b = temp.get(j);
                j = a > b ? j + 1 : j;
                sum += Math.min(a, b);
            }
        }
        return sum;
    }
}
