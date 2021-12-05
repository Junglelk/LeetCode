package competition.medium.competition_5944.Step_By_StepDirectionsFromABinaryTreeNodeToAnother;

import org.junit.Test;
import other.TreeNode;

/**
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
 * <p>
 * Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
 * <pre>
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * </pre>
 * Return the step-by-step directions of the shortest path from node s to node t.
 * 给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
 * <p>
 * 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
 * <pre>
 * 'L' 表示从一个节点前往它的 左孩子 节点。
 * 'R' 表示从一个节点前往它的 右孩子 节点。
 * 'U' 表示从一个节点前往它的 父 节点。
 * </pre>
 * 请你返回从 s 到 t 最短路径 每一步的方向。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/5 15:08
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1).left = new TreeNode(3);
        root.right = new TreeNode(2).left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        System.out.println(getDirections(root, 3, 6));
    }

    String getDirections(TreeNode root, int s, int d) {

        return "";
    }
}
