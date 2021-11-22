package normal.medium.question_0384.ShuffleAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
 * <p>
 * Implement the Solution class:
 *
 * <pre>
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * </pre>
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 *
 * <pre>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * </pre>
 * <pre>
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/22 22:08
 */
public class Solution {

    private int[] random;
    private int[] source;

    public Solution(int[] nums) {
        int[] temp1 = new int[nums.length];
        int[] temp2 = new int[nums.length];
        System.arraycopy(nums, 0, temp1, 0, nums.length);
        this.random = temp2;
        this.source = nums;
    }

    public int[] reset() {
        return source;
    }

    public int[] shuffle() {
        // 123 132 213 231 312 321
        List<Integer> list = new ArrayList<>();
        for (int i : source) {
            list.add(i);
        }
        for (int i = 0; i < random.length; i++) {
            int index = (int) (Math.random() * list.size());
            random[i] = list.remove(index);
        }
        return random;
    }
}
