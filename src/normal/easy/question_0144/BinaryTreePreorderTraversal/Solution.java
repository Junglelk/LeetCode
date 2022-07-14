package normal.easy.question_0144.BinaryTreePreorderTraversal;

import other.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal">binary-tree-preorder-traversal</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/10 22:03
 */
public class Solution {
    /**
     * 递归写法
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorderRec(root, res);
        return res;
    }

    public void preorderRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderRec(root.left, res);
        preorderRec(root.right, res);
    }

    /**
     * 非递归写法
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> preorderNoRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return list;
    }
}
