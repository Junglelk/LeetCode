package normal.medium.question_0056.MergeIntervals_56;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * <p>
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/30
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{0,4}})));
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        // 这里应该是对对第一个元素排序，所以我写成了 i[1] 淦
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> merge = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0];
            int R = interval[1];
            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < L) {
                merge.add(new int[]{L, R});
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], R);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
