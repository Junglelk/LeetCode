package normal.easy.question_0145.BinaryTreePostorderTraversal;

import other.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * 给定一个二叉树，返回它的 后序 遍历。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal">binary-tree-postorder-traversal</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/10 22:13
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderRec(root, res);
        return res;
    }

    public void postorderRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderRec(root.left, res);
        postorderRec(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderNoRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
