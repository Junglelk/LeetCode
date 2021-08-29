package competition_5856.MinimumNumberOfWorkSessionsToFinishTheTasks;

import org.junit.Test;

import java.util.Arrays;

/**
 * 你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
 * <p>
 * 你需要按照如下条件完成给定任务：
 * <p>
 * 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
 * 完成一个任务后，你可以 立马 开始一个新的任务。
 * 你可以按 任意顺序 完成任务。
 * 给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
 * <p>
 * 测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
 *
 * @author Jungle
 * @since 2021/8/29 11:34
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(minSessions(new int[]{3, 1, 3, 1, 1}, 8));
        System.out.println(minSessions(new int[]{1, 2, 3, 4, 5}, 15));
        System.out.println(minSessions(new int[]{1, 2, 3}, 3));

    }


    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int times = 0;
        int temp = sessionTime;
        int sum = 0;
        for (int task : tasks) {
            sum += task;
        }
        if (sum <= sessionTime) {
            return 1;
        }
        for (int i = 0; i < tasks.length-1; i++) {
            int task = tasks[i];
            temp -= task;
            if (temp <= 0 || tasks[i+1]+temp < sessionTime) {
                times++;
                temp = sessionTime;
            }
        }
        return times;
    }
}
