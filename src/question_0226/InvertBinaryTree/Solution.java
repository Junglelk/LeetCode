package question_0226.InvertBinaryTree;

import other.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * 翻转一棵二叉树。
 *
 * <pre>
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/14 21:48
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left;
            TreeNode right;
            left = root.right;
            right = root.left;

            root.left = left;
            root.right = right;
            invertTree(root.left);
            invertTree(root.right);
        }
        return null;
    }
}
