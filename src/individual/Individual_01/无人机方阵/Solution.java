package individual.Individual_01.无人机方阵;

import org.junit.jupiter.api.Test;

/**
 * 在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：
 * <p>
 * 调整无人机的位置布局
 * 切换无人机展示的灯光颜色
 * 给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
 * <p>
 * 注意： 调整无人机的位置布局时无人机的位置可以随意变动。
 * <pre>
 * 输入：source = [[1,3],[5,4]], target = [[3,1],[6,5]]
 *
 * 输出：1
 *
 * 解释：
 * 最佳方案为
 * 将 [0,1] 处的无人机移动至 [0,0] 处；
 * 将 [0,0] 处的无人机移动至 [0,1] 处；
 * 将 [1,0] 处的无人机移动至 [1,1] 处；
 * 将 [1,1] 处的无人机移动至 [1,0] 处，其灯光颜色切换为颜色编号为 6 的灯光；
 * 因此从source 到 target 所需要的最少灯光切换次数为 1。
 * </pre>
 * <pre>
 * 输入：source = [[1,2,3],[3,4,5]], target = [[1,3,5],[2,3,4]]
 *
 * 输出：0
 * 解释：
 * 仅需调整无人机的位置布局，便可完成图案切换。因此不需要无人机切换颜色
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/11 15:03
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(minimumSwitchingTimes(new int[][]{{1, 3}, {4, 5}}, new int[][]{{1, 3}, {6, 5}}));
    }

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int exchange = 0;

        return exchange;
    }


}
