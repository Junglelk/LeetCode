package question_0456.Q132Pattern;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 * <p>
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * <p>
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/19 22:43
 */
public class Solution {

    /**
     * 单调递增栈
     * <pre>
     * for(int i = 0; i < T.size(); i++){
     *   while(! stk.empty() && stk.top() > T[i]){
     *          stk.pop();
     *   }
     *   stk.push(A[i]);
     * }
     * </pre>
     * 单调递减栈
     * <pre>
     * for(int i = T.size() - 1; i >= 0; i--){
     *   while(! stk.empty() && T[i] >= stk.top()){
     *      stk.pop();
     *   }
     *   stk.push(i);
     * }
     *  </pre>
     */
    @Test
    public void test() {
        // [-2,1,2,-2,1,2]
        System.out.println(find132pattern(new int[]{1, -5, 1, 4, 5, 2, 1, 4, 5, -6, 5, 4, 1, 5, 7, -12, 8, 7, 1, 2, 6, -1, 5, 3, 2, 3, 4}));
    }

    /**
     * 单调栈的作用：
     * <p>
     * 可以以 O(1) 的时间复杂度得知某个位置左右两侧比他大（或小）的数的位置，当你需要高效率获取某个位置左右两侧比他大（或小）的数的位置的的时候就可以用到单调栈。
     * <p>
     * 单调递增栈：从栈底到栈顶，数值单调增加
     * <p>
     * 单调递减栈：从栈底到栈顶，数值单调减少
     * <pre>
     * 求解数组中元素右边第一个比它小的元素的下标，从前往后，构造单调递增栈；
     * 求解数组中元素右边第一个比它大的元素的下标，从前往后，构造单调递减栈；
     * 求解数组中元素左边第一个比它小的元素的下标，从后往前，构造单调递减栈；
     * 求解数组中元素左边第一个比它小的元素的下标，从后往前，构造单调递增栈。
     * </pre>
     * <p>
     * 从后向前维护构造一个单调递减的单调栈，获取元素左边第一个比它小的元素的下标。以 [3, 1, 4, 2] 为例：
     * 从后向前，入栈 2 ，遍历到 4 ，2->4递增，不满足，所以出栈 2 入栈 4，继续遍历到 1，出栈的 2 与 1 相比，大于 1 ，说明 后面
     *
     * @param nums 待验证数组
     * @return 是否符合要求
     */
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int k = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            // 若当前元素比栈顶大，则将栈内小于该数字的元素丢弃，循环结束后，栈内应只有这个元素
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
