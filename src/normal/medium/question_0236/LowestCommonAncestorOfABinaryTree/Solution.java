package normal.medium.question_0236.LowestCommonAncestorOfABinaryTree;

import other.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/6 21:45
 */
public class Solution {
    /**
     * 本题的关键在于，当前根节点的左右子树是否分别包含p、q节点
     *
     * @param root 根节点
     * @param p    目标节点1
     * @param q    目标节点2
     * @return 公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历到的子树节点是否存在目标节点。不存在返回null
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 递归遍历操作
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右子树分别遍历到了目标节点，说明当前根节点是公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 否则继续遍历那个存在目标节点的子树
        if (left != null) {
            return left;
        }
        return right;
    }
}
