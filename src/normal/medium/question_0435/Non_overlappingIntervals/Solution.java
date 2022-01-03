package normal.medium.question_0435.Non_overlappingIntervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <pre>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/3 21:02
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(eraseOverlapIntervals(new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}}));
    }



    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        // 保存没有交集的区间
        Deque<int[]> stack = new LinkedList<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            int[] temp = stack.peek();

            if (temp[0] == L) {
                temp[1] = Math.min(temp[1], R);
            }

            // 收缩原有区间
            if (R < temp[1]) {
                stack.pop();
                stack.push(intervals[i]);
                continue;
            }
            // 非重叠区间，直接填入
            if (temp[1] <= L) {
                stack.push(intervals[i]);
            }
        }
        return intervals.length - stack.size();
    }
}
