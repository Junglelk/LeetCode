package normal.medium.question_1014.BestSightseeingPair;

/**
 * Description:
 * <p>
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
 * <p>
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 * <p>
 * Return the maximum score of a pair of sightseeing spots.
 * <p>
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/best-sightseeing-pair">best-sightseeing-pair</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/9/28 20:09
 */
public class Solution {
    /**
     * 错解，时间复杂度过高
     *
     * @param values 待排数组
     * @return 答案
     */
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(max, values[i] + values[j] + i - j);
            }
        }
        return max;
    }

    /**
     * 我们考虑从前往后遍历j来统计答案，对于每个观光景点j而言,我们需要遍历[0,j - 1] 的观光景点i来计算组成观光组合
     * (i,j)得分的最大值cnt来作为第j个观光景点的值，那么最后的答案无疑就是所有观光景点值的最大值。但是遍历j需要O(n)的时间复杂度,
     * 遍历[0,j- 1] 的观光景点i也需要O(n)的时间复杂度，
     * 因此该方法总复杂度为O(n2),不能通过所有测试用例，我们需要进一步优化时间复杂度。
     * 我们回过头来看得分公式，我们可以将其拆分成values[i] + i和values[j]- j两部分,这样对于统计景点j答案的时候，由于values[j] - j是固定不变的，因此最大化values[i] + i + values[j] - j的值其实就等价于求
     * [0,j- 1]中的values[i] + i最大值mx, 景点j的答案即为 mx+ values[j]- j。而mx的值我们只要从前往后遍历j的时候同时维护即可，这样每次遍历到景点j的时候，寻找使得得分最大的i就能从O(n)降至O(1)的时间复杂度，总时间复杂度就能从O(n2)降至O(n)。
     *
     * @param values 待排数组
     * @return 答案
     */
    public int maxScoreSightseeingPairAns(int[] values) {
        int ans = 0, mx = values[0];
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }
}
