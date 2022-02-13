package normal.medium.question_0513.FindBottomLeftTreeValue;

import other.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/13 21:06
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    left = poll.val;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return left;
    }
}
