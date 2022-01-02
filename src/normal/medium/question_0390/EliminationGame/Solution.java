package normal.medium.question_0390.EliminationGame;

/**
 * You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:
 * <pre>
 * Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
 * Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * </pre>
 * Given the integer n, return the last number that remains in arr.
 * <p>
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <pre>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * </pre>
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/2 15:19
 */
public class Solution {
    /**
     * https://leetcode-cn.com/problems/elimination-game/solution/gong-shui-san-xie-yue-se-fu-huan-yun-yon-x60m/
     *
     * @param n 目标值
     * @return 结果值
     */
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
