package normal.medium.question_1609.EvenOddTree;

import other.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A binary tree is named Even-Odd if it meets the following conditions:
 * <pre>
 * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 * For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 * </pre>
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 * <p>
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <pre>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * </pre>
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/26 15:59
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 奇数递增，偶数递减
            int preVal = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            // 每次遍历皆为一层
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollFirst();
                int num = temp.val;

                if (flag && (num <= preVal || num % 2 == 0)) {
                    return false;
                }
                if (!flag && (num >= preVal || num % 2 != 0)) {
                    return false;
                }
                preVal = num;
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }

            }
            flag = !flag;
        }
        return true;
    }
}
