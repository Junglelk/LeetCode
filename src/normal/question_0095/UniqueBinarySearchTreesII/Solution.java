package normal.question_0095.UniqueBinarySearchTreesII;

import org.junit.jupiter.api.Test;
import other.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * <p>
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案
 *
 * <pre>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）<br>
 * 链接：<a href="https://leetcode-cn.com/problems/unique-binary-search-trees-ii">unique-binary-search-trees-ii</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br>
 *
 * @author Jungle
 * @since 2021/9/2 22:35
 */
public class Solution {

    @Test
    public void test() {
        // TODO: 2022/7/29 做是不可能会做的，只能抄个答案写个todo在这里勉强混日子的样子
        System.out.println(generateTrees(5));
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
