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
    /**
     * 队列大小不应当作为遍历时的比较条件，因为大小是动态变化的。<br>
     * 这题的基本思路与我一开始一致，但是为什么没能将一开始的思路转换为代码呢？；<br>
     * 一方面是忘记了双端队列的一些特征，一直以来都仅仅是将其视为栈的替代品；也就是说，基础不够牢靠。<br>
     * 另一方面，今晚想要冲击到200道题，有些急了。好在确实能独立写出来这个代码，要对今晚的思想引以为戒。<br>
     *
     * @param root 根节点
     * @return 目标列表
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 显然第一层左到右，第二层右到左。后面奇偶性与遍历方式一致
        // 第一层左到右
        boolean order = true;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            // 犯了一个很老土的错误
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                // 当为奇数层时，从左往右，即每次将数值插入到双端队列的最新位置，基于队列的先进先出，
                // 就是从左到右的顺序。偶数层与之相反
                assert temp != null;
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
