package question_0101.SymmetricTree;

import lombok.val;
import other.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/14 21:23
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        } else if (root.right == null && root.left == null) {
            return false;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode head = list.poll();
            val size = list.size();
            for (int i = 0; i < size; i++) {
                if (head.left != null && head.right != null) {
                    if (head.left.val == head.right.val) {
                        list.add(head.left);
                        list.add(head.right);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
