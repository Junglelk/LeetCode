package normal.medium.question_1962.RemoveStonesToMinimizeTheTotal;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:
 * <p>
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 * <p>
 * Return the minimum possible total number of stones remaining after applying the k operations.
 * <p>
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 * <p>
 * 给你一个整数数组 piles ，数组下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰好 k 次：
 * <p>
 * 选出任一石子堆 piles[i] ，并从中移除 floor(piles[i] / 2) 颗石子。
 * 注意：你可以对 同一堆 石子多次执行此操作。
 * <p>
 * 返回执行 k 次操作后，剩下石子的 最小 总数。
 * <p>
 * floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-stones-to-minimize-the-total
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/5 21:35
 */
public class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int ans = 0;
        for (int i : piles) {
            queue.add(i);
            ans += i;
        }
        // 重复 k 次
        while (k != 0) {
            // 大顶堆，每次取出最多的
            int poll = queue.poll();
            int t = poll / 2;
            ans -= t;
            // 再将减完后的放入堆中
            queue.add(poll - t);
            k--;
        }
        return ans;
    }
}
