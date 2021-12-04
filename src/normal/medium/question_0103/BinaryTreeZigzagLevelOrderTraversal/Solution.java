package normal.medium.question_0103.BinaryTreeZigzagLevelOrderTraversal;

import other.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <pre>
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 锯齿遍历结果如下：
 * <pre>
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/4 22:47
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        queue.offer(root);
        // 显然第一层左到右，第二层右到左。后面奇偶性与遍历方式一致
        // 第一层左到右
        boolean order = true;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode temp = queue.poll();
                //
                if (order) {
                    list.offerLast(temp.val);
                } else {
                    list.offerFirst(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            ret.add(new LinkedList<>(list));
            order = !order;

        }
        return ret;
    }
}
