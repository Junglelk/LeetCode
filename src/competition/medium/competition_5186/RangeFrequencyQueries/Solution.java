package competition.medium.competition_5186.RangeFrequencyQueries;

/**
 * Design a data structure to find the frequency of a given value in a given subarray.
 * <p>
 * The frequency of a value in a subarray is the number of occurrences of that value in the subarray.
 * <p>
 * Implement the RangeFreqQuery class:
 * <p>
 * RangeFreqQuery(int[] arr) Constructs an instance of the class with the given 0-indexed integer array arr.
 * int query(int left, int right, int value) Returns the frequency of value in the subarray arr[left...right].
 * A subarray is a contiguous sequence of elements within an array. arr[left...right] denotes the subarray that contains the elements of nums between indices left and right (inclusive).
 * <p>
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * <p>
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * <p>
 * 请你实现 RangeFreqQuery 类：
 * <p>
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 * <p>
 * <pre>
 * ["RangeFreqQuery", "query", "query"]
 * [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
 * 输出：
 * [null, 1, 2]
 *
 * 解释：
 * RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
 * rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
 * rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-frequency-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/21 15:08
 */
public class Solution {

}
// TODO 显然的非正式解，但我不想看正解了
class RangeFreqQuery {

    private int[] arr;

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int value) {
        int nums = 0;
        for (int i = left; i < right + 1; i++) {
            if (arr[i] == value) {
                nums++;
            }
        }
        return nums;
    }
}