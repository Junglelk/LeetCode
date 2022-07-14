package normal.easy.question_0094.BinaryTreeInorderTraversal;

import other.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/10 22:11
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderRec(root, res);
        return res;
    }

    public void inorderRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderRec(root.left, res);
        res.add(root.val);
        inorderRec(root.right, res);
    }

    public List<Integer> inorderNoRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
