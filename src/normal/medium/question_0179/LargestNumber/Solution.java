package normal.medium.question_0179.LargestNumber;

import java.util.PriorityQueue;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/18 21:00
 */
public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> j - i);
        for (int num : nums) {
            int temp = num;
            while (temp != 0) {
                queue.add(temp % 10);
                temp /= 10;
            }
        }
        StringBuilder stb = new StringBuilder();
        while (!queue.isEmpty()) {
            stb.append(queue.poll());
        }
        return stb.toString();
    }
}
