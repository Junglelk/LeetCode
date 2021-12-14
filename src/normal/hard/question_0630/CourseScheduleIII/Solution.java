package normal.hard.question_0630.CourseScheduleIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.
 * <p>
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 * <p>
 * Return the maximum number of courses that you can take.
 * <p>
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * <p>
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * <p>
 * 返回你最多可以修读的课程数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/14 22:08
 */
public class Solution {
    /**
     * 对于两门课 (t_1, d_1) 和 (t_2, d_2)，如果后者的关闭时间较晚，即 d_1 <= d_2，那么我们先学习前者，再学习后者，总是最优的。
     * 这是个结论，但我不会证明。
     * <p>
     * 算法
     * <p>
     * 我们需要一个数据结构支持「取出 t 值最大的那门课程」，因此我们可以使用优先队列（大根堆）。
     * <p>
     * 我们依次遍历每一门课程，当遍历到 (t_i, d_i)时：
     * <p>
     * 如果当前优先队列中所有课程的总时间与 t_i 之和小于等于 d_i，那么我们就把 t_i 加入优先队列中；
     * <p>
     * 如果当前优先队列中所有课程的总时间与 t_i 之和大于 d_i，那么我们找到优先队列中的最大元素 t_xj。如果 t_xj > t_i ，则将它移出优先队列，并把 t_i加入优先队列中。
     * <p>
     * 在遍历完成后，优先队列中包含的元素个数即为答案。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule-iii/solution/ke-cheng-biao-iii-by-leetcode-solution-yoyz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param courses 课程表
     * @return 课程数
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0];
            int di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }
        return q.size();
    }
}