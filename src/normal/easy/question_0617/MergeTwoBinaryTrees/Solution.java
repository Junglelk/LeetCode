package normal.easy.question_0617.MergeTwoBinaryTrees;


import other.TreeNode;

/**
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/merge-two-binary-trees">merge-two-binary-trees</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode te = new TreeNode(root1.val + root2.val);
        te.left = mergeTrees(root1.left, root2.left);
        te.right = mergeTrees(root1.right, root2.right);
        return te;
    }
}
