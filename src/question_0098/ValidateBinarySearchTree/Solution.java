package question_0098.ValidateBinarySearchTree;

import org.junit.Test;
import other.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 *
 * <pre>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees
 * </pre>
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <pre>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * </pre>
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/26 21:42
 */
public class Solution {

    @Test
    public void test() {
        TreeNode b = new TreeNode(5);
        b.left = new TreeNode(4);
        b.right = new TreeNode(6);
        b.right.left = new TreeNode(3);
        b.right.right = new TreeNode(7);
        System.out.println(isValidBSTRe(b));
    }


    public boolean isValidBST(TreeNode root) {
        // 这个解法只考虑了局部解，未考虑完全解
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null && (root.val >= root.right.val || root.val <= root.left.val)) {
            return false;
        } else if (root.left != null && root.val <= root.left.val) {
            return false;
        } else if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBSTRe(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 每层保留此分支上一层的最小值，或最大值，保证本层不会越界
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
